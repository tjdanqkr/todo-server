package com.todo.dev.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class LoginRequest {
    private String memberId;
    private String memberPw;
}
