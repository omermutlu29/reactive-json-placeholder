package com.example.demo.domain;

import lombok.Builder;

@Builder
public record TodoManipulated (
        String title,
        Boolean completed,
        Integer id
){

}
