    package com.managment.system.repositories;

    import com.managment.system.entites.User;
    import org.springframework.data.repository.CrudRepository;

    import java.util.Optional;

    public interface UserRepositories extends CrudRepository<User, Long> {
        Optional<User> findByUsername(String username);
    }
