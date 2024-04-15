package com.texas.ams.service.impl;

import com.texas.ams.dto.StudentDto;
import com.texas.ams.dto.UserDto;
import com.texas.ams.model.Student;
import com.texas.ams.model.User;
import com.texas.ams.repo.StudentRepo;
import com.texas.ams.repo.UserRepo;
import com.texas.ams.service.StudentService;
import com.texas.ams.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
//
//    @Override
//    public Integer save(StudentDto studentDto) {
//        Student student = new Student();
//        student.setName(studentDto.getName());
//        student.setAddress(studentDto.getAddress());
//        student.setPresent(studentDto.isPresent()); // Assuming StudentDto has a method isPresent() returning a boolean
//        Student savedStudent = studentRepo.save(student);
//        return savedStudent.getId();
//    }

    @Override
    public Integer save(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setPresent(studentDto.isPresent()); // Ensure isPresent is properly set
        Student savedStudent = studentRepo.save(student);
        return savedStudent.getId();
    }

    @Override
    public StudentDto getById(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("Student Not Found");
        }
        else{
            Student student = studentOptional.get();
            StudentDto studentDto = new StudentDto(
                    student.getName(),student.getAddress(),student.getPresent()
            );
            return studentDto;
        }
    }

    @Override
    public List<StudentDto> getAll() {
        return List.of();
    }


//    @Override
//    public List<UserDto> getAll() {
//        List<User> userList = userRepo.findAll();
//        List<UserDto> userDtoList = userList.stream()
//                .map(user -> {
//                    UserDto userDto = new UserDto(
//                            user.getId(), user.getUsername(),user.getRole()
//                    );
//                    return userDto;
//                }).collect(Collectors.toList());
//        return userDtoList;
//    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User getUser(Integer id) {
        return null;
    }
}
