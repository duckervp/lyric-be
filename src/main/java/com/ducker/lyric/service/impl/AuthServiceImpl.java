package com.ducker.lyric.service.impl;

import com.ducker.lyric.config.context.TokenContextHolder;
import com.ducker.lyric.dto.Token;
import com.ducker.lyric.dto.request.auth.ChangePasswordRequest;
import com.ducker.lyric.dto.request.auth.LoginRequest;
import com.ducker.lyric.dto.request.auth.RefreshTokenRequest;
import com.ducker.lyric.dto.request.auth.RegisterRequest;
import com.ducker.lyric.dto.response.LoginResponse;
import com.ducker.lyric.enums.Role;
import com.ducker.lyric.enums.apicode.AuthApiCode;
import com.ducker.lyric.enums.apicode.CommonApiCode;
import com.ducker.lyric.exception.ApiException;
import com.ducker.lyric.model.User;
import com.ducker.lyric.repository.UserRepository;
import com.ducker.lyric.service.AuthService;
import com.ducker.lyric.service.AuthTokenService;
import com.ducker.lyric.utils.AuthUtils;
import com.ducker.lyric.utils.RegexUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AuthTokenService authTokenService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String removeRefreshToken(RefreshTokenRequest request) {
        TokenContextHolder.removeRefreshToken(request.getRefreshToken());
        return "Removed refresh token successfully!";
    }

    @Override
    public String changePassword(ChangePasswordRequest request) {
        if (!StringUtils.hasText(request.getOldPassword())) {
            throw new ApiException(AuthApiCode.PASSWORD_IS_REQUIRED);
        }

        if (!StringUtils.hasText(request.getNewPassword())) {
            throw new ApiException(AuthApiCode.NEW_PASSWORD_REQUIRED);
        }

        User user = userRepository.findById(AuthUtils.currentUserId())
                .orElseThrow(() -> new ApiException(AuthApiCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new ApiException(AuthApiCode.GIVEN_PASSWORD_INCORRECT);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        return "Changed password successfully!";
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ApiException(AuthApiCode.EMAIL_OR_PASSWORD_IS_INCORRECT));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user,
                        request.getPassword(),
                        user.getAuthorities()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return getLoginResponse(user);
    }

    @Override
    @Transactional
    public LoginResponse register(RegisterRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new ApiException(AuthApiCode.NAME_IS_REQUIRED);
        }

        if (!StringUtils.hasText(request.getEmail())) {
            throw new ApiException(AuthApiCode.EMAIL_IS_REQUIRED);
        }

        if (!RegexUtils.EMAIL_PATTERN_V2.matcher(request.getEmail()).find()) {
            throw new ApiException(AuthApiCode.INVALID_EMAIL);
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ApiException(AuthApiCode.EMAIL_IS_IN_USED);
        }

        User user = User.builder()
                .status(true)
                .role(Role.USER)
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return getLoginResponse(user);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest request) {
        if (!StringUtils.hasText(request.getRefreshToken())) {
            throw new ApiException(AuthApiCode.INVALID_REFRESH_TOKEN);
        }

        Token refreshToken =  TokenContextHolder.getUserRefreshToken(
                request.getRefreshToken(),
                AuthApiCode.INVALID_REFRESH_TOKEN,
                AuthApiCode.REFRESH_TOKEN_EXPIRED);

        User user = userRepository.findById(refreshToken.getUserId())
                .orElseThrow(() -> new ApiException(AuthApiCode.USER_NOT_FOUND_WITH_GIVEN_ID));

        return getLoginResponse(user);
    }

    public LoginResponse getLoginResponse(User user) {
        try {
            Token token = authTokenService.createRefreshToken(user.getId());
            String accessToken = authTokenService.createAccessToken(user);
            return LoginResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(token.getValue())
                    .refreshTokenExpiredAt(token.getExpiredAt())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
        } catch (Exception e) {
            log.error("Error: ", e);
            throw new ApiException(CommonApiCode.ERROR);
        }
    }
}
