package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record UserPost(
        @JsonProperty("user")
        User user,

        @JsonProperty("posts")
        List<Post> posts
) {


    // getters and setters
}