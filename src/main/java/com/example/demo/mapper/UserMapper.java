package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.domain.UserManipulated;

public class UserMapper {

    public static UserManipulated UserToUserManipulated(User user) {
        return UserManipulated.builder()
                .id(user.id())
                .name(user.name())
                .surname(user.surname())
                .email(user.email())
                .build();
    }
}
