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
        //JPA 의 영속성 컨텍스트 덕분에 entity 객체의 값만 변경하면 자동으로 변경사항 반영함!
        //따라서 repository.update 를 쓰지 않아도 됨.
        task.update( requestDto.getContent(),requestDto.getStatus(),requestDto.getModified_date());
        return id;
    }
    public void deleteTodoById(final Long id){
        todoRepo.deleteById(id);
    }
}

