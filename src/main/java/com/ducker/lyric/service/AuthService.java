package com.ducker.lyric.service;

import com.ducker.lyric.dto.request.auth.ChangePasswordRequest;
import com.ducker.lyric.dto.request.auth.LoginRequest;
import com.ducker.lyric.dto.request.auth.RefreshTokenRequest;
import com.ducker.lyric.dto.request.auth.RegisterRequest;
import com.ducker.lyric.dto.response.LoginResponse;


public interface AuthService {
    LoginResponse login(LoginRequest request);

    LoginResponse register(RegisterRequest request);

    LoginResponse refreshToken(RefreshTokenRequest request);

    String removeRefreshToken(RefreshTokenRequest request);

    String changePassword(ChangePasswordRequest request);
}
