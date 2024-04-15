package com.texas.ams.controller;

import com.texas.ams.dto.UserDto;
import com.texas.ams.model.User;
import com.texas.ams.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        Integer data = userService.save(userDto);
        return ResponseEntity.ok(
                Map.of("message","User saved Successfully.")
        );
    }

}
