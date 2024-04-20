package com.texas.ams.service.impl;

import com.texas.ams.dto.AttendanceRequestDto;
import com.texas.ams.dto.DisplayAttendanceDto;
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
        List<Integer> presentStudentIdList = attendanceRequestDto.getPresentStudentIds();
        List<Integer> absentStudentIdList = attendanceRequestDto.getAbsentStudentIds();

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

        List<StudentAttendance> absentStudentAttendanceList = absentStudentIdList.stream()
                .map(studentId -> {
                    Student student = studentRepo.findById(studentId).orElseThrow(
                            () -> new RuntimeException("Student Not Found")
                    );
                    StudentAttendance attendance = new StudentAttendance();
                    attendance.setStudent(student);
                    attendance.setAttendanceDate(LocalDate.now());
                    attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
                    return attendance;
                }).collect(Collectors.toList());
//        attendanceRepo.saveAll(absentStudentAttendanceList);
        List<StudentAttendance> allAttendanceList = new ArrayList<>();
        allAttendanceList.addAll(presentStudentAttendaceList);
        allAttendanceList.addAll(absentStudentAttendanceList);
        attendanceReportRepo.saveAll(allAttendanceList);
        return allAttendanceList.size();
    }
    @Override
    public List<DisplayAttendanceDto> getAttendanceListByDate(LocalDate date) {
        List<StudentAttendance> attendaceList = attendanceReportRepo.findAttendaceByDate(date);
        List<DisplayAttendanceDto> dateWiseAttendaceList = attendaceList.stream()
                .map(attendance -> {
                    DisplayAttendanceDto attendanceResponseDto = new DisplayAttendanceDto(attendance.getStudent().getName(), date, attendance.getAttendanceStatus());
                    return attendanceResponseDto;
                }).collect(Collectors.toList());

        return dateWiseAttendaceList;
    }
}
