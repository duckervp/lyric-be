package com.ducker.lyric.dto.request.auth;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldPassword;

    private String newPassword;
}
