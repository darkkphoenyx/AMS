package com.texas.ams.controller;

import com.texas.ams.dto.UserDto;
import com.texas.ams.model.User;
import com.texas.ams.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
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

    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable Integer id) {
        UserDto data = userService.getById(id);
            return ResponseEntity.ok(
                    Map.of("message", "User Fetched Successfully.", "data", data)
            );
    }
    @GetMapping("/list")
    public ResponseEntity fetchAllUsers(){
        List<UserDto> data = userService.getAll();
        return ResponseEntity.ok(
                Map.of("message","User List Fetched Successfully..","data",data)
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
