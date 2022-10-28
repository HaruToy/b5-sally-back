package com.sds.todolist.service;

import com.sds.todolist.web.domain.Task;
import com.sds.todolist.web.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepo;

    public List<Task> getTodos() throws IllegalAccessException {
        List<Task> tasks = todoRepo.findAll();

        if(!tasks.isEmpty()) return todoRepo.findAll();
        else throw new IllegalAccessException("no such data");
    }

    public Task getTodoById(final Long id){
        return todoRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no such data"));
    }
    @Transactional
    public Task createTodo(final Task createTask){
        if(createTask ==null) throw new IllegalArgumentException("task can't be null");
        return todoRepo.save(createTask);
    }

    public void deleteTodoById(final Long id){
        todoRepo.deleteById(id);
    }
}

