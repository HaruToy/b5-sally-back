package com.sds.todolist.web.controller;

import com.sds.todolist.service.TodoService;
import com.sds.todolist.web.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @Autowired // Constructor 를 통한 Di
    public TodoApiController(TodoService TodoService) {
        this.todoService = TodoService;
    }
    @PostMapping("/api/tasks")
    public Task save(@RequestBody Task requestDto) {
        return todoService.createTodo(requestDto);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return ResponseEntity.ok()
                .body(todoService.createTodo(task));
    }
}