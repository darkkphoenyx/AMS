package com.texas.ams.controller;

import com.texas.ams.dto.StudentDto;
import com.texas.ams.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity saveStudent(@Valid @RequestBody StudentDto studentDto) {
        Integer data = studentService.save(studentDto);
        return ResponseEntity.ok(
                Map.of("message","Student saved Successfully.")
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity fetchStudentById(@PathVariable Integer id) {
        StudentDto data = studentService.getById(id);
        return ResponseEntity.ok(
                Map.of("message", "Student Fetched Successfully.", "data", data)
        );
    }
    @GetMapping("/list")
    public ResponseEntity fetchAllStudents(){
        List<StudentDto> data = studentService.getAll();
        return ResponseEntity.ok(
                Map.of("message","Student List Fetched Successfully..","data",data)
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") Integer id) {
            studentService.deleteById(id);
            return ResponseEntity.ok("Student Deleted Successfully...");
    }

}
