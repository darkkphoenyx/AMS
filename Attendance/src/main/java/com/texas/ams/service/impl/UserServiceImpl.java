package com.texas.ams.service.impl;

import com.texas.ams.dto.UserDto;
import com.texas.ams.model.User;
import com.texas.ams.repo.UserRepo;
import com.texas.ams.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User Not Found");
        }
        else{
            User user = userOptional.get();
            UserDto userDto = new UserDto(
                    user.getId(), user.getUsername(),user.getRole()
            );
            return userDto;
        }
    }


    @Override
    public List<UserDto> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User getUser(Integer id) {
        return null;
    }
}
