package com.sds.todolist.service;

import com.sds.todolist.web.domain.Todo;
import com.sds.todolist.web.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepo;

    public List<Todo> getTodos() throws IllegalAccessException {
        List<Todo> todos = todoRepo.findAll();

        if(!todos.isEmpty()) return todoRepo.findAll();
        else throw new IllegalAccessException("no such data");
    }

    public Todo getTodoById(final Long id){
        return todoRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no such data"));
    }
    @Transactional
    public Todo createTodo(final Todo createTodo){
        if(createTodo ==null) throw new IllegalArgumentException("task can't be null");
        return todoRepo.save(createTodo);
    }

    public void deleteTodoById(final Long id){
        todoRepo.deleteById(id);
    }
}

