package com.lv08.basic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DefaultController {

    @GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

}
