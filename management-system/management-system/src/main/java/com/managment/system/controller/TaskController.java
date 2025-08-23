package com.managment.system.controller;

import com.managment.system.Dto.TaskDto;
import com.managment.system.entites.Status;
import com.managment.system.entites.Task;
import com.managment.system.repositories.TaskRepositories;
import com.managment.system.service.serviceimp.ServiceTaskImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final ServiceTaskImp serviceTask;
    private final TaskRepositories taskRepositories;


    public TaskController(ServiceTaskImp serviceTask, TaskRepositories taskRepositories) {
        this.serviceTask = serviceTask;
        this.taskRepositories = taskRepositories;
    }
    @Operation(summary = "Create a new task", description = "Creates a task for the logged-in user")
    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @RequestBody TaskDto taskDto,
            Authentication authentication
    )
    {
        String username = authentication.getName();
        TaskDto createdTask = serviceTask.createTask(taskDto, username);
        if (createdTask == null) {
            return ResponseEntity.badRequest().build();
        }
        ;
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "View tasks", description = "Retrieves tasks for the logged-in user. Can filter by status and title")
    public ResponseEntity<List<TaskDto>> viewtask(
            @RequestParam(value = "status", defaultValue = "To_Do") Status status,
            @RequestParam(value = "title", defaultValue = "") String title,
            Authentication authentication
    ) {
        String username = authentication.getName();
        List<TaskDto> viewtask = serviceTask.viewTask(status, title, username);

        if (viewtask == null || viewtask.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(viewtask);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a task", description = "Updates a task by ID. Only the owner can update it")
    public ResponseEntity<?> updateTask(
            @PathVariable Long id,
            @RequestBody TaskDto taskDto,
            Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Task> optionalTask = taskRepositories.findById(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        if (!task.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot edit this task");
        }

        task.setTitle(taskDto.getTitle());
        task.setTaskname(taskDto.getTaskname());
        task.setDescraption(taskDto.getDescraption());
        task.setStatus(taskDto.getStatus());
        Task updated = taskRepositories.save(task);

        return ResponseEntity.ok(TaskDto.toDto(updated));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task", description = "Deletes a task by ID. Only the owner can delete it")
    public ResponseEntity<?> deleteTask(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String username = authentication.getName();
        Optional<Task> optionalTask = taskRepositories.findById(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        if (!task.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot delete this task");
        }

        taskRepositories.delete(task);
        return ResponseEntity.ok("Task deleted successfully");
    }



}
