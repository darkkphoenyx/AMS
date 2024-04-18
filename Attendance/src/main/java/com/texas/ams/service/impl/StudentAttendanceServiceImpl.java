package com.texas.ams.service.impl;

import com.texas.ams.dto.AttendanceRequestDto;
import com.texas.ams.enums.AttendanceStatus;
import com.texas.ams.model.Student;
import com.texas.ams.model.StudentAttendance;
import com.texas.ams.repo.AttendanceReportRepo;
import com.texas.ams.repo.StudentRepo;
import com.texas.ams.service.StudentAttendanceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
    private final AttendanceReportRepo attendanceReportRepo;
    private final StudentRepo studentRepo;

    public StudentAttendanceServiceImpl(AttendanceReportRepo attendanceReportRepo, StudentRepo studentRepo) {
        this.attendanceReportRepo = attendanceReportRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public Integer doAttendance(AttendanceRequestDto attendanceRequestDto) {
        List<Integer> presentStudentIdList = attendanceRequestDto.getStudentIds();

        List<StudentAttendance> presentStudentAttendaceList= presentStudentIdList.stream()
                .map(studentId->{
                    Student student = studentRepo.findById(studentId).orElseThrow(
                            () -> new RuntimeException("Student Not Found")
                    );
                    StudentAttendance studentAttendance=new StudentAttendance();
                    studentAttendance.setStudent(student);
                    studentAttendance.setAttendanceDate(LocalDate.now());
                    studentAttendance.setAttendanceStatus(AttendanceStatus.PRESENT);
                    return studentAttendance;
                }).collect(Collectors.toList());
        attendanceReportRepo.saveAll(presentStudentAttendaceList);
        return 1;
    }
}
