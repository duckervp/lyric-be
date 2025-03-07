package com.ducker.lyric.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Token {
    private Long userId;
    private String value;
    private Instant expiredAt;

    public static Token from(Long userId, String value, Instant expiredAt) {
        return Token.builder()
                .userId(userId)
                .value(value)
                .expiredAt(expiredAt)
                .build();
    }
}
