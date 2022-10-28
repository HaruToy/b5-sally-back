package com.sds.todolist;

import com.sds.todolist.web.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>{
 @Override
    Todo save(Todo todo);

 @Override
 Optional<Todo> findById(Long id);

 @Override
    void deleteById(Long id);
}
