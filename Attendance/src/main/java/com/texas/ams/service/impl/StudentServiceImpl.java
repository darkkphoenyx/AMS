package com.texas.ams.service.impl;

import com.texas.ams.dto.StudentDto;
import com.texas.ams.model.Student;
import com.texas.ams.repo.StudentRepo;
import com.texas.ams.service.StudentService;
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
        Student student;
        if (studentDto.getId()!=null && studentDto.getId()>0) {
            student = studentRepo.findById(studentDto.getId()).orElseThrow(
                    () -> new RuntimeException("Student Not Found")
            );
        }else{
            student = new Student();
        }
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
                    student.getId(),student.getName(),student.getAddress(),student.getAge(),student.getFather_Name(),student.getMother_Name(),student.getPhone(),student.getEmail(),student.getGender()
            );
            return studentDto;
        }
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> studentList = studentRepo.findAll();
        List<StudentDto> studentDtoList = studentList.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto(
                    student.getId(),student.getName(),student.getAddress(),student.getAge(),student.getFather_Name(),student.getMother_Name(),student.getPhone(),student.getEmail(),student.getGender()
            );
                    return studentDto;
                }).collect(Collectors.toList());
        return studentDtoList;
    }


    @Override
    public void deleteById(Integer id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Student Not Found");
        }
    }

//    @Override
//    public void update(StudentDto studentDto) {
//        Student student = studentRepo.findById(studentDto.getId()).orElseThrow(
//                () -> new RuntimeException("Student Not Found")
//        );
//        student.setName(studentDto.getName());
//        student.setAddress(studentDto.getAddress());
//        student.setAge(studentDto.getAge());
//        student.setFather_Name(studentDto.getFather_Name());
//        student.setMother_Name(studentDto.getMother_Name());
//        student.setPhone(studentDto.getPhone());
//        student.setEmail(studentDto.getEmail());
//        student.setGender(studentDto.getGender());
//        studentRepo.save(student);
//    }
}
