package com.lv08.basic.controllers;

import com.google.gson.Gson;
import com.lv08.basic.entities.User;
import com.lv08.basic.resources.UserResource;
import com.lv08.basic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "User", value = "/users")
public class UserController {

    private static final Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> userList = userService.findAll();
            return ResponseEntity.ok().body(userList);
        } catch (Exception err) {
            return ResponseEntity.status(501).build();
        }
    }

    @GetMapping
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok().body(user);
        } catch (Exception err) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserResource reqBody) {
        try {
            User userData = userService.resourceToEntity(reqBody);
            userService.create(userData);

            return ResponseEntity.ok().build();
        } catch (Exception err) {
            return ResponseEntity.status(500).build();
        }
    }
}
