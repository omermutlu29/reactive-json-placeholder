package com.example.demo.domain;

public record Address
        (
                String nullField,
                String street,
                String suite,
                String city,
                String zipcode
        ){
}
