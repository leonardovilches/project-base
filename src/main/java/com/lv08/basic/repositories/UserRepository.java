package com.lv08.basic.repositories;

import com.lv08.basic.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    User findByEmail(String email);

    User findByUsername(String username);

    @Override
    List<User> findAll();
}
