package com.todo.dev.controller;

import com.todo.dev.domain.dto.TodosPost;
import com.todo.dev.domain.request.TodosPostRequest;
import com.todo.dev.security.SecurityService;
import com.todo.dev.security.TokenRequired;
import com.todo.dev.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
@TokenRequired
public class TodosController {
    private final TodosService todosService;
    private final SecurityService securityService;
    @PostMapping
    public Integer postTodos(@RequestBody TodosPostRequest request){
        Integer memberId = securityService.parseToken(securityService.getToken()).getId();
        TodosPost todosPost = TodosPost.builder()
                .member_id(memberId).content(request.getContent())
                .build();
        return todosService.insertTodoService(todosPost);
    }
}
