package com.example.demo.domain;

public record Post (
        Integer userId,
        Long id,
        String title,
        String body
){
}
