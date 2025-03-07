package com.ducker.lyric.rest;

import com.ducker.lyric.base.Response;
import com.ducker.lyric.base.WebConstants;
import com.ducker.lyric.dto.request.user.AvatarRequest;
import com.ducker.lyric.dto.request.user.UserNameRequest;
import com.ducker.lyric.dto.request.user.FindUserRequest;
import com.ducker.lyric.dto.request.user.UserRequest;
import com.ducker.lyric.model.User;
import com.ducker.lyric.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(WebConstants.API_USER_PREFIX_V1)
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Response<PagedModel<User>>> getAllUsers(FindUserRequest request) {
        return ResponseEntity.ok(Response.success(userService.findAll(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<User>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(Response.success(userService.findById(id)));
    }

    @PatchMapping("/update-name")
    public ResponseEntity<Response<String>> updateUserName(@RequestBody UserNameRequest request) {
        return ResponseEntity.ok(Response.success(userService.updateName(request)));
    }

    @PatchMapping("/update-avatar")
    public ResponseEntity<Response<String>> updateAvatar(@RequestBody AvatarRequest request) {
        return ResponseEntity.ok(Response.success(userService.updateAvatar(request)));
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<String>> save(@RequestBody UserRequest request) {
        return ResponseEntity.ok(Response.success(userService.save(request)));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<String>> update(@PathVariable Long id, @RequestBody UserRequest request) {
        return ResponseEntity.ok(Response.success(userService.update(id, request)));
    }

    @DeleteMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<String>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(Response.success(userService.delete(id)));
    }

    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<String>> delete(@PathVariable List<Long> ids) {
        return ResponseEntity.ok(Response.success(userService.delete(ids)));
    }
}
