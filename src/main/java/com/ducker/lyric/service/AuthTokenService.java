package com.ducker.lyric.service;

import com.ducker.lyric.dto.Token;
import com.ducker.lyric.model.User;

import java.time.Instant;

public interface AuthTokenService {

    Token createRefreshToken(Long userId);

    long getExpireDate(Instant expiredAt);

    String createAccessToken(User user);

    String createAccessToken(User user, long expireMils);

}
