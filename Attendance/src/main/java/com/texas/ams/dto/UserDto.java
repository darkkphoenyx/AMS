package com.texas.ams.dto;

import com.texas.ams.enums.Role;
import jakarta.validation.constraints.NotNull;

public class UserDto {

    private Integer id;

    @NotNull(message = "username is Mandatory")
    private String username;

    @NotNull(message = "password is Mandatory")
    private String password;

    @NotNull(message = "role is Mandatory")
    private Role role;

    public UserDto(Integer id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDto(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDto() {
    }

    public UserDto(Integer id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
