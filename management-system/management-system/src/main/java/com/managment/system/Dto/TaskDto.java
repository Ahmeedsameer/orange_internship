package com.managment.system.Dto;

import com.managment.system.entites.Status;
import com.managment.system.entites.Task;
import com.managment.system.entites.User;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDto {
    private long id;
    private String taskname;
    private String title;
    private String descraption;
    private Status status;
    private Long userId;
    private LocalDate dueDate;

    public static TaskDto toDto(Task task) {

        if (task == null) {
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescraption(task.getDescraption());
        taskDto.setStatus(task.getStatus());
        taskDto.setTitle(task.getTitle());
        taskDto.setUserId(task.getUser().getId());
        taskDto.setTaskname(task.getTaskname());
        taskDto.setDueDate(task.getDueDate());
        return taskDto;
    }

    public static Task toEntity(TaskDto dto, User user) {
        if (dto == null || user == null) {
            return null;
        }
        Task task = new Task();
        task.setId(dto.getId());
        task.setDescraption(dto.getDescraption());
        task.setTitle(dto.getTitle());
        task.setTaskname(dto.getTaskname());
        task.setStatus(dto.getStatus());
        task.setUser(user);
        task.setDueDate(dto.getDueDate());
        return task;
    }
    public static List<TaskDto> toDtoList(List<Task> list) {
        List<TaskDto> dtos = new ArrayList<>();
        for (Task task : list) {
            dtos.add(toDto(task));
        }
        return dtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescraption() {
        return descraption;
    }

    public void setDescraption(String descraption) {
        this.descraption = descraption;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
