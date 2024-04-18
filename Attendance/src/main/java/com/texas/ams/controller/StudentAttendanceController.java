package com.texas.ams.controller;

import com.texas.ams.dto.AttendanceRequestDto;
import com.texas.ams.dto.StudentDto;
import com.texas.ams.service.StudentAttendanceService;
import com.texas.ams.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student-attendance")
public class StudentAttendanceController {
    private final StudentAttendanceService studentAttendanceService;

    public StudentAttendanceController(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }


    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody AttendanceRequestDto attendanceRequestDto) {
        Integer data = studentAttendanceService.doAttendance(attendanceRequestDto);
        return ResponseEntity.ok(
                Map.of("message","Attendance done Successfully.")
        );
    }

}
