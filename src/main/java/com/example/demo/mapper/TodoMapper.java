package com.example.demo.mapper;

import com.example.demo.domain.Todo;
import com.example.demo.domain.TodoManipulated;
import org.springframework.stereotype.Service;

@Service
public class TodoMapper {
    public static TodoManipulated TodoToTodoManipulated(Todo todo) {
        return TodoManipulated.builder()
                .id(todo.id())
                .completed(todo.completed() == "true")
                .title(todo.title())
                .build();
    }
}
