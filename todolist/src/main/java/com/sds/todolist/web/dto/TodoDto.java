package com.sds.todolist.web.dto;

import com.sds.todolist.web.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class TodoDto {
    private String owner;
    private String content;
    private String status;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    @Builder
    public TodoDto(String owner,String content, String status,LocalDateTime created_date){
        this.owner=owner;
        this.content=content;
        this.status=status;
        this.created_date=created_date;
    }

    public Todo toEntity(){
        return Todo.builder().owner(owner).content(content).status(status).created_date(created_date).build();
    }
}