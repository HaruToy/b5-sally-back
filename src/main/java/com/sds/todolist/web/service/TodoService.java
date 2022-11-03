package com.sds.todolist.web.service;

import com.sds.todolist.web.domain.Task;
import com.sds.todolist.web.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepo;

    public List<Task> getTodos() throws IllegalAccessException {
        List<Task> tasks = todoRepo.findAll(Sort.by("id"));

        return todoRepo.findAll(Sort.by("id"));

    }

    public Task getTodoById(final Long id){
        return todoRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no such data"));
    }

    public Task createTodo(final Task createTask){
        if(createTask ==null) throw new IllegalArgumentException("task can't be null");
        return todoRepo.save(createTask);
    }

    public Long update(Long id, Task requestDto) {
        Task task = todoRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("없다"+id));
        todoRepo.save(requestDto);
        return id;
    }
    public void deleteTodoById(final Long id){
        todoRepo.deleteById(id);
    }
}

