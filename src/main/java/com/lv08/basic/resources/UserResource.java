package com.lv08.basic.resources;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserResource {

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    public UserResource (String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
