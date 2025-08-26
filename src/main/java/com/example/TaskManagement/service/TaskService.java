package com.example.TaskManagement.service;

import com.example.TaskManagement.model.Task;
import java.util.*;

public interface TaskService {
    
    Task addTask(Task task);
    
    Task getTaskById(Long id);

    List<Task> getAllTasks();

    void deleteTask(Long id);

    Task updateTask(Long id,Task updatedtask);

    Task getRecommendedTask();
}
