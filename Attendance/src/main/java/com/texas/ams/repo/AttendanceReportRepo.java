package com.texas.ams.repo;

import com.texas.ams.model.Student;
import com.texas.ams.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceReportRepo extends JpaRepository<StudentAttendance,Integer> {
}
