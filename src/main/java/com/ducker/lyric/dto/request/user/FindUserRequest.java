package com.ducker.lyric.dto.request.user;

import com.ducker.lyric.dto.request.PageRequest;
import com.ducker.lyric.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindUserRequest extends PageRequest {
    private String email;

    private String name;

    private Role role;

    private Boolean status;
}
