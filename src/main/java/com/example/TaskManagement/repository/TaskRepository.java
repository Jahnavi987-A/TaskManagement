package com.example.TaskManagement.repository;

import com.example.TaskManagement.model.Task;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    

    List<Task> findByPriority(String priority);

    List<Task> findByStatus(String status);

    List<Task> findByDeadlineBefore(LocalDateTime dateTime);

    List<Task> findByDeadlineAfter(LocalDateTime dateTime);
    
}
