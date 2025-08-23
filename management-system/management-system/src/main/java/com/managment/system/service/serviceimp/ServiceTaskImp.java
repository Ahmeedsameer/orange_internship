    package com.managment.system.service.serviceimp;

    import com.managment.system.Dto.TaskDto;
    import com.managment.system.entites.Status;
    import com.managment.system.entites.Task;
    import com.managment.system.entites.User;
    import com.managment.system.repositories.TaskRepositories;
    import com.managment.system.repositories.UserRepositories;
    import com.managment.system.service.ServiceTask;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service

    public class ServiceTaskImp implements ServiceTask {
      TaskRepositories taskRepositories;
      UserRepositories userRepositories;
        @Autowired
        public ServiceTaskImp(UserRepositories userRepositories, TaskRepositories taskRepositories) {
            this.userRepositories = userRepositories;
            this.taskRepositories = taskRepositories;
        }

        @Override
        public TaskDto createTask(TaskDto taskDto,String username) {
         if (taskDto==null){
             return null;
         }
         Optional<User> user=userRepositories.findByUsername(username);
         if (!user.isPresent()){
             return null;
         }
         User myUser =user.get();
         Task task=TaskDto.toEntity(taskDto , myUser);
         Task save=taskRepositories.save(task);
         return TaskDto.toDto(save);
        }

        @Override
            public List<TaskDto> viewTask(Status Status, String title, String username) {
               Optional<User> user=userRepositories.findByUsername(username);
               if (user.isEmpty()){
                   return  null;
               }
                   List<Task>tasks = new ArrayList<>();
               if (Status!=null&&title!=null&&!title.isBlank()){
                tasks=taskRepositories.findByUserIdAndStatusAndTitleContainingIgnoreCase(user.get().getId(), Status,title);
               }
               else if (Status != null && (title == null || title.isBlank())){
                   tasks=taskRepositories.findByUserIdAndStatus(user.get().getId(),Status);
               } else if (Status==null&&title!=null&&!title.isBlank()) {
                   tasks=taskRepositories.findByUserIdAndTitleContainingIgnoreCase( user.get().getId(),title);
               }
                  return TaskDto.toDtoList(tasks);
            }

        @Override
        public TaskDto updateTask(Long id, TaskDto taskDto, Status status) {// هحسن فيها
            if (id==null||taskDto==null){
                return null;
            }
            Optional<Task> taskid=taskRepositories.findById(id);
            if (taskid.isEmpty()){
                return null;
            }
            Task task=taskid.get() ;
            if (taskDto.getTaskname() != null && !taskDto.getTaskname().isBlank()) {
                task.setTaskname(taskDto.getTaskname());
            }

            if (taskDto.getTitle() != null && !taskDto.getTitle().isBlank()) {
                task.setTitle(taskDto.getTitle());
            }
            if (taskDto.getDescraption() != null && !taskDto.getDescraption().isBlank()) {
                task.setDescraption(taskDto.getDescraption());
            }
            if (status != null) {
                task.setStatus(status);
            }

            Task updatedTask = taskRepositories.save(task);

            return TaskDto.toDto(updatedTask);
        }

        @Override
        public void deleteTask(Long id) {
        if (id==null){
            return ;
        }
        Optional<Task> deletid=taskRepositories.findById(id);
        if (deletid.isPresent()){
            taskRepositories.delete(deletid.get());
        }
        }
    }
