package com.todo.dev.repository;

import com.todo.dev.domain.dto.Todos;
import com.todo.dev.domain.dto.TodosPost;
import com.todo.dev.domain.request.TodosPostRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodosRepository {
    Integer insert(Todos todos);
    Integer check(Integer id, Integer member_id);

}
