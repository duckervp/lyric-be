package com.ducker.lyric.service;

import com.ducker.lyric.dto.request.user.AvatarRequest;
import com.ducker.lyric.dto.request.user.UserNameRequest;
import com.ducker.lyric.dto.request.user.UserRequest;
import com.ducker.lyric.dto.request.user.FindUserRequest;
import com.ducker.lyric.model.User;
import org.springframework.data.web.PagedModel;

import java.util.List;

public interface UserService {
    String save(UserRequest request);

    PagedModel<User> findAll(FindUserRequest request);

    String update(Long id, UserRequest request);

    String delete(Long id);

    String delete(List<Long> ids);

    User findById(Long id);

    String updateName(UserNameRequest request);

    String updateAvatar(AvatarRequest request);
}
