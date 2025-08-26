package com.example.TaskManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.repository.TaskRepository;
import com.example.TaskManagement.service.TaskService;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task){
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        task.setStatus("PENDING");
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(()->new RuntimeException("Task not found"));
    }

    @Override
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id,Task updatedtask){
        Task existingTask = getTaskById(id);
        existingTask.setTitle(updatedtask.getTitle());
        existingTask.setDescription(updatedtask.getDescription());
        existingTask.setDeadline(updatedtask.getDeadline());
        existingTask.setStatus(updatedtask.getStatus());
        existingTask.setPriority(updatedtask.getPriority());
        existingTask.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(existingTask);
    }

    @Override
    public Task getRecommendedTask(){
        List<Task> tasks = taskRepository.findByStatus("PENDING");

        return tasks.stream().min(Comparator.comparing(Task::getDeadline).thenComparing(Task::getPriority)).orElseThrow(()->new RuntimeException("No tasks available"));
    }
}
