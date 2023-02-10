package com.todo.dev.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Members {
    private Integer id;
    private String member_id;
    private String member_pw;
    private String name;
    private String phone_number;

}
