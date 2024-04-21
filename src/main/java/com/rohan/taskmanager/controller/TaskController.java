package com.rohan.taskmanager.controller;

import com.rohan.taskmanager.model.Task;
import com.rohan.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping("/allTasks")
    public List<Task> getTasks() {
        return service.findAllTasks();
    }


    @GetMapping("/tasks")
    public Task getTask(@RequestParam String taskId){
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity")
    public List<Task> findTaskUsingSeverity(@RequestParam int severity){
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee")
    public List<Task> getTaskByAssignee(@RequestParam String assignee){
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping("/tasks")
    public Task modifyTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/tasks")
    public String deleteTask(@RequestParam String taskId){
        return service.deleteTask(taskId);
    }
}