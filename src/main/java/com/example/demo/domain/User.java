package com.example.demo.domain;

public record User (
        Integer id,
        String name,
        String surname,
        String email,
        Address address
){
}
