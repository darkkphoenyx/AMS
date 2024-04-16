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

    @Override
    public Integer save(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setAge(studentDto.getAge());
        student.setFather_Name(studentDto.getFather_Name());
        student.setMother_Name(studentDto.getMother_Name());
        student.setPhone(studentDto.getPhone());
        student.setEmail(studentDto.getEmail());
        student.setGender(studentDto.getGender());
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
                    student.getName(),student.getAddress(),student.getAge(),student.getFather_Name(),student.getMother_Name(),student.getPhone(),student.getEmail(),student.getGender()
            );
            return studentDto;
        }
    }

    @Override
    public List<StudentDto> getAll() {
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
