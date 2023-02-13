package com.todo.dev.domain.response;

import com.todo.dev.domain.entity.Todos;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class MyTodosResponse {
    private final Integer id;
    private final LocalDateTime createDate;
    private final String content;
    private final boolean checked;

    public MyTodosResponse(Todos todos){
        this.id = todos.getId();
        this.createDate = todos.getCreateDate();
        this.content = todos.getContent();
        this.checked = todos.getChecked();
    }
}
