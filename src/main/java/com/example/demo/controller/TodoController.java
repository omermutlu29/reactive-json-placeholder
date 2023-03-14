package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("json-placeholder")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("todos")
    public Flux<TodoManipulated> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("users")
    public Flux<UserManipulated> getUsers() {
        return todoService.getUsers();
    }

    @GetMapping("user-todos/{id}")
    public Flux<TodoManipulated> getUserTodos(@PathVariable Integer id) {
        return todoService.getUserTodos(id);
    }

    @GetMapping("addresses")
    public Flux<Address> getAddresses(){
        return todoService.getAddresses();
    }

    @GetMapping("user-posts")
    public Flux<UserPost> getUserPosts(){
        return todoService.getUserPosts();
    }


}
