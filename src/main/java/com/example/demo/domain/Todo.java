package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

@Builder
public record Todo (
        Integer userId,
        Integer id,
        String title,
        String completed
){
}
