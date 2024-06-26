package com.texas.ams.service;

import com.texas.ams.dto.StudentDto;
import java.util.List;

public interface StudentService {
    Integer save(StudentDto studentDto);
    StudentDto getById(Integer id);


    List<StudentDto> getAll();


    void deleteById(Integer id);

}
