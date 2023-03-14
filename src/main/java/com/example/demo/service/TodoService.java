package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.mapper.TodoMapper;
import com.example.demo.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class TodoService {

    @Qualifier("jsonPlaceholder")
    private final TodoRequestService todoRequestService;

    public Flux<TodoManipulated> getTodos() {
        return todoRequestService.getTodos()
                .map(TodoMapper::TodoToTodoManipulated);
    }

    public Flux<UserManipulated> getUsers() {
        return todoRequestService.getUsers().map(UserMapper::UserToUserManipulated);

    }

    public Flux<TodoManipulated> getUserTodos(Integer userId) {
        Flux<Todo> todos = todoRequestService.getTodos();
        return todos.filter(todo -> todo.userId().equals(userId)).map(TodoMapper::TodoToTodoManipulated);
    }


    public Flux<Address> getAddresses() {
        return todoRequestService.getUsers().map(User::address);
    }

    public Flux<UserPost> getUserPosts() {
        final long start = System.nanoTime();
        Flux<Post> posts = todoRequestService.getPosts();
        Flux<User> users = todoRequestService.getUsers();

        return users.flatMap(user -> {
            Flux<Post> userPosts = posts.filter(post -> post.userId().equals(user.id()));
            return userPosts.collectList().map(ps -> concatPostsAndUser(ps, user));
        }).doFinally(endType -> System.out.println("Time taken : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " milliseconds."));


    }


    private static UserPost concatPostsAndUser(List<Post> posts, User user) {
        return UserPost
                .builder()
                .user(user)
                .posts(posts)
                .build();
    }

}
