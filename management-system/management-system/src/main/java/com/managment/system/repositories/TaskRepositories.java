package com.managment.system.repositories;
import com.managment.system.entites.Status;
import com.managment.system.entites.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;


public interface TaskRepositories extends CrudRepository<Task, java.lang.Long> {
    List<Task> findByUserId(Long userid);
    List<Task>findByUserIdAndStatus(Long userid, Status status);
    List<Task> findByUserIdAndTitleContainingIgnoreCase(Long userid, String title);
    List<Task> findByUserIdAndStatusAndTitleContainingIgnoreCase(Long userId, Status status, String title);
    Optional<Task>findByIdAndUserId(Long taskid, Long userid);
    List<Task> findByUser(User user);


}
