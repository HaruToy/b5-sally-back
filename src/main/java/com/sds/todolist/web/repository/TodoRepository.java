package com.sds.todolist.web.repository;

import com.sds.todolist.web.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Task, Long>{
 @Override
 Task save(Task task);
// @Override
// List<Task> findAllOrderByCreated_date();
 @Override
 List<Task> findAll();
 @Override
 Optional<Task> findById(Long id);

 @Override
    void deleteById(Long id);


}
