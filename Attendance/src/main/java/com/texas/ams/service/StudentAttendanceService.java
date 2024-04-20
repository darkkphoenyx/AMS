package com.texas.ams.service;

import com.texas.ams.dto.AttendanceRequestDto;
import com.texas.ams.dto.DisplayAttendanceDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentAttendanceService {
    Integer doAttendance(AttendanceRequestDto attendanceRequestDto);

    List<DisplayAttendanceDto> getAttendanceListByDate(LocalDate date);
}
