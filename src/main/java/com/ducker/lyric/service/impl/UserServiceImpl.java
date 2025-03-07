package com.ducker.lyric.service.impl;

import com.ducker.lyric.dto.request.user.AvatarRequest;
import com.ducker.lyric.dto.request.user.UserNameRequest;
import com.ducker.lyric.dto.request.user.UserRequest;
import com.ducker.lyric.dto.request.user.FindUserRequest;
import com.ducker.lyric.enums.Role;
import com.ducker.lyric.enums.apicode.AuthApiCode;
import com.ducker.lyric.exception.ApiException;
import com.ducker.lyric.model.User;
import com.ducker.lyric.repository.UserRepository;
import com.ducker.lyric.service.FileService;
import com.ducker.lyric.service.UserService;
import com.ducker.lyric.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final FileService fileService;

    @Override
    public String updateAvatar(AvatarRequest request) {
        User user = userRepository.findById(AuthUtils.currentUserId())
                .orElseThrow(() -> new ApiException(AuthApiCode.USER_NOT_FOUND));

        if (StringUtils.hasText(request.getAvatarUrl())) {
            fileService.deleteFile(user.getAvatarUrl());
        }

        user.setAvatarUrl(request.getAvatarUrl());
        userRepository.save(user);
        return "Updated avatar successfully!";
    }

    @Override
    public String updateName(UserNameRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new ApiException(AuthApiCode.NAME_IS_REQUIRED);
        }

        User user = userRepository.findById(AuthUtils.currentUserId())
                .orElseThrow(() -> new ApiException(AuthApiCode.USER_NOT_FOUND));

        user.setName(request.getName());
        userRepository.save(user);
        return "Update user name successfully!";
    }

    @Override
    public String save(UserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(request.getRole())
                .status(request.getStatus())
                .build();

        userRepository.save(user);
        return "Save user successful";
    }

    @Override
    public PagedModel<User> findAll(FindUserRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSort()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        return new PagedModel<>(userRepository.findUser(request, pageable));
    }

    @Override
    public String update(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setRole(request.getRole());
        user.setStatus(request.getStatus());

        userRepository.save(user);
        return "Update user successful";
    }

    @Override
    public String delete(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        if (Role.USER.equals(AuthUtils.currentRole()) && !user.getId().equals(AuthUtils.currentUserId())) {
            throw new ApiException(AuthApiCode.PERMISSION_DENIED);
        }

        user.setDeleted(true);

        userRepository.save(user);
        return "Delete user successful";
    }

    @Override
    public String delete(List<Long> ids) {
        List<User> users = userRepository.findAllById(ids);
        for (User user : users) {
            user.setDeleted(true);
        }

        userRepository.saveAll(users);
        return "Delete users successful";
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        if (Role.USER.equals(AuthUtils.currentRole()) && !user.getId().equals(AuthUtils.currentUserId())) {
            throw new ApiException(AuthApiCode.PERMISSION_DENIED);
        }

        return user;
    }
}
