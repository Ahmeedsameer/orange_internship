    package com.managment.system.service;

    import com.managment.system.Dto.TaskDto;
    import com.managment.system.entites.Status;
    import com.managment.system.entites.User;

    import java.util.List;

    public interface ServiceTask {
    public TaskDto createTask(TaskDto taskDto , String username );
    public List<TaskDto> viewTask(Status Status ,String title,String username);
    public TaskDto updateTask(Long id, TaskDto taskDto, Status status );
    public void deleteTask(Long id );
    }
