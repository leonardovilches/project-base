package com.lv08.basic.services;

import com.lv08.basic.entities.Role;
import com.lv08.basic.entities.User;
import com.lv08.basic.repositories.RoleRepository;
import com.lv08.basic.repositories.UserRepository;
import com.lv08.basic.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User create(User userData) {
        try {
//            Role adminRole = roleRepository.findByName("ADMIN");
//            List<Role> roles = new ArrayList<>();
//            roles.add(adminRole);
//            userData.setRoles(roles);
            User user = userRepository.save(userData);
            return user;
        } catch (IllegalArgumentException err) {
            throw err;
        }
    }

    public User findByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email);
            return user;
        } catch (Exception err) {
            throw err;
        }
    }

    public User findByUsername(String username) {
        try {
            User user = userRepository.findByUsername(username);
            return user;
        } catch (Exception err) {
            throw err;
        }
    }

    public List<User> findAll() {
        try {
            List<User> userList = userRepository.findAll();
            return userList;
        } catch (Exception err) {
            throw err;
        }
    }

    public User resourceToEntity(UserResource userResource) {
        try {
            String password = encoder.encode(userResource.getPassword());
            User user = new User(userResource.getUsername(), userResource.getEmail(), password);
            return user;
        } catch (Exception err) {
            throw err;
        }
    }
}
