package com.todo.dev.controller;

import com.todo.dev.domain.dto.FriendTodos;
import com.todo.dev.domain.dto.TodosPost;
import com.todo.dev.domain.request.TodosPostRequest;
import com.todo.dev.domain.response.HomeTodosResponse;
import com.todo.dev.domain.response.MyTodosResponse;
import com.todo.dev.security.SecurityService;
import com.todo.dev.security.TokenRequired;
import com.todo.dev.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodosController {
    private final TodosService todosService;
    private final SecurityService securityService;
    @PostMapping @TokenRequired
    public Integer postTodos(@RequestBody TodosPostRequest request){
        Integer memberId = securityService.parseToken(securityService.getToken()).getId();
        TodosPost todosPost = TodosPost.builder()
                .member_id(memberId).content(request.getContent())
                .build();
        return todosService.insertTodoService(todosPost);
    }
    @PutMapping("/{id}") @TokenRequired
    public Integer checkTodos(@PathVariable("id") Integer id){
        Integer memberId = securityService.parseToken(securityService.getToken()).getId();
        return todosService.checkTodo(id, memberId);

    }
    @GetMapping("/home") @TokenRequired
    public List<HomeTodosResponse> homeTodos(){
        return todosService.homeTodos(securityService.parseToken(securityService.getToken()).getId());
    }
    @GetMapping("/my") @TokenRequired
    public List<MyTodosResponse> myTodos(){
        return todosService.myTodos(securityService.parseToken(securityService.getToken()).getId());
    }
    
    @GetMapping("/friend") @TokenRequired
    public List<FriendTodos> getMyFriendTodos(){
        Integer myId = securityService.parseToken(securityService.getToken()).getId();
        return todosService.getFriendTodos(myId);
    }
}
