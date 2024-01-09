package com.example.demo.controller;

import com.example.demo.Models.Task;
import com.example.demo.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private TaskRepo taskRepo;
    @GetMapping(value="/")
    public String getpage(){
        return "welcome";
    }
    @GetMapping(value="/tasks")
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }
    @PostMapping(value="/save")
    public String saveTask(@RequestBody Task task){
        taskRepo.save(task);
        return "saved";
    }
    @PutMapping(value="update/{id}")
    public String updateTask(@PathVariable long id,@RequestBody Task task){
        Task updatedTask=taskRepo.findById(id).get();
        updatedTask.setTask(task.getTask());
        updatedTask.setDeadline(task.getDeadline());
        updatedTask.setCompleted(task.isCompleted());
        taskRepo.save(updatedTask);
        return "updated";
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){
        Task deleteTask=taskRepo.findById(id).get();
        taskRepo.delete(deleteTask);
        return "deleted";
    }
}
