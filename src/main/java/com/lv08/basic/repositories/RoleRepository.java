package com.lv08.basic.repositories;

import com.lv08.basic.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository <Role, UUID> {

    Role findByName(String name);

}
