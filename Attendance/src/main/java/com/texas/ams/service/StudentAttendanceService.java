package com.texas.ams.service;

import com.texas.ams.dto.AttendanceRequestDto;

public interface StudentAttendanceService {
    Integer doAttendance(AttendanceRequestDto attendanceRequestDto);
}
