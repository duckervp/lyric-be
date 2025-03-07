package com.ducker.lyric.service.impl;

import com.ducker.lyric.config.context.TokenContextHolder;
import com.ducker.lyric.config.property.AuthProperty;
import com.ducker.lyric.dto.Token;
import com.ducker.lyric.model.User;
import com.ducker.lyric.service.AuthTokenService;
import com.ducker.lyric.utils.AuthTokenUtils;
import com.ducker.lyric.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthTokenServiceImpl implements AuthTokenService {

    private final AuthProperty authProperty;

    @Override
    public Token createRefreshToken(Long userId) {
        Instant expiredAt = DateTimeUtils.getCurrentInstantMilliseconds().plusMillis(
            authProperty.getRefreshTokenExpirationMils());
        String value = UUID.randomUUID().toString();
        Token token = Token.from(userId, value, expiredAt);
        TokenContextHolder.setUserRefreshToken(token);
        return token;
    }

    @Override
    public long getExpireDate(Instant expiredAt) {
        Instant maxExpiryDate = DateTimeUtils.plusMils(DateTimeUtils.now(), authProperty.getAccessTokenExpirationMils());
        if (expiredAt.isBefore(maxExpiryDate)) {
            return DateTimeUtils.milsBetween(DateTimeUtils.now(), expiredAt);
        } else {
            return authProperty.getAccessTokenExpirationMils();
        }
    }

    @Override
    public String createAccessToken(User user) {
        String value = AuthTokenUtils.createAccessToken(
            user.getId(),
            User.getUserInfo(user),
            authProperty.getAccessTokenExpirationMils(),
            authProperty.getTokenSecret());
        Instant expiredAt = DateTimeUtils.getCurrentInstantMilliseconds().plusMillis(
            authProperty.getAccessTokenExpirationMils());
        Token token = Token.from(user.getId(), value, expiredAt);
        TokenContextHolder.setUserAccessToken(token);
        return value;
    }

    @Override
    public String createAccessToken(User user, long expireMils) {
        String value = AuthTokenUtils.createAccessToken(
            user.getId(),
            User.getUserInfo(user),
            expireMils,
            authProperty.getTokenSecret());
        Instant expiredAt = DateTimeUtils.getCurrentInstantMilliseconds().plusMillis(
            expireMils);
        Token token = Token.from(user.getId(), value, expiredAt);
        TokenContextHolder.setUserAccessToken(token);
        return value;
    }

}
