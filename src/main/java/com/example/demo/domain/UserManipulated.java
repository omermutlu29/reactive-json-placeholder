package com.example.demo.domain;

import lombok.Builder;

@Builder
public record UserManipulated (
        Integer id,
        String email,
        String name,
        String surname
){
}
