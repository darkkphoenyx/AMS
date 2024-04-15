package com.texas.ams.service;

import com.texas.ams.dto.UserDto;
import com.texas.ams.model.User;

import java.util.List;

public interface UserService {
    Integer save(UserDto userDto);
    UserDto getById(Integer id);


    List<UserDto> getAll();


    void deleteById(Integer id);

    User getUser(Integer id);

}
