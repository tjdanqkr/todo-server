package com.todo.dev.domain.dto;

import com.todo.dev.domain.entity.Todos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class TodosPost {
    private Integer member_id;
    private String content;
    public Todos toDTO(){
        return Todos.builder()
                .memberId(member_id)
                .content(content)
                .build();
    }
}
