package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.Todo;
import com.example.demo.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class TodoRequestService {

    @Qualifier("jsonPlaceholder")
    private final WebClient jsonPlaceholderWebClient;

    private static final String baseUri = "https://jsonplaceholder.typicode.com/";

    public Flux<Todo> getTodos() {
        return jsonPlaceholderWebClient.get().uri(baseUri + "todos")
                .retrieve().bodyToFlux(Todo.class);

    }

    public Flux<User> getUsers() {
        return jsonPlaceholderWebClient.get().uri(baseUri + "users")
                .retrieve().bodyToFlux(User.class);
    }

    public Flux<Post> getPosts() {

        return jsonPlaceholderWebClient.get().uri(baseUri + "posts")
                .retrieve().bodyToFlux(Post.class);
    }


}
