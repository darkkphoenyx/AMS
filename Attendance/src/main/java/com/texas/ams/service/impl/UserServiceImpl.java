package com.texas.ams.service.impl;

import com.texas.ams.dto.UserDto;
import com.texas.ams.model.User;
import com.texas.ams.repo.UserRepo;
import com.texas.ams.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user;
        if (userDto.getId()!=null && userDto.getId()>0) {
            user = userRepo.findById(userDto.getId()).orElseThrow(
                    () -> new RuntimeException("Student Not Found")
            );
        }else{
            user = new User();
        }
        //encoding the password using Bcrypt
        String plainPassword=(userDto.getPassword());
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);

        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User Not Found");
        } else {
            User user = userOptional.get();
            UserDto userDto = new UserDto(
                    user.getId(), user.getUsername(), user.getRole()
            );
            return userDto;
        }
    }


    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepo.findAll();
        List<UserDto> userDtoList = userList.stream()
                .map(user -> {
                    UserDto userDto = new UserDto(
                            user.getId(), user.getUsername(), user.getRole()
                    );
                    return userDto;
                }).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteById(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User Not Found");
        }
    }

}
