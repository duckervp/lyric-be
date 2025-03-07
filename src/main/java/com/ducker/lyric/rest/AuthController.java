package com.ducker.lyric.rest;

import com.ducker.lyric.base.Response;
import com.ducker.lyric.base.WebConstants;
import com.ducker.lyric.dto.request.auth.ChangePasswordRequest;
import com.ducker.lyric.dto.request.auth.LoginRequest;
import com.ducker.lyric.dto.request.auth.RefreshTokenRequest;
import com.ducker.lyric.dto.request.auth.RegisterRequest;
import com.ducker.lyric.dto.response.LoginResponse;
import com.ducker.lyric.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(WebConstants.API_AUTH_PREFIX_V1)
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(Response.success(authService.login(request)));
    }

    @PostMapping("/register")
    public ResponseEntity<Response<LoginResponse>> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(Response.success(authService.register(request)));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Response<LoginResponse>> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(Response.success(authService.refreshToken(request)));
    }

    @DeleteMapping("/refresh-token")
    public ResponseEntity<Response<String>> removeRefreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(Response.success(authService.removeRefreshToken(request)));
    }

    @PatchMapping("/change-password")
    public ResponseEntity<Response<String>> changePassword(@RequestBody ChangePasswordRequest request) {
        return ResponseEntity.ok(Response.success(authService.changePassword(request)));
    }

}
