package com.sds.todolist.web.dto;

import com.sds.todolist.web.domain.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    public Task toEntity(){
        return Task.builder().owner(owner).content(content).status(status).created_date(created_date).build();
    }
}
