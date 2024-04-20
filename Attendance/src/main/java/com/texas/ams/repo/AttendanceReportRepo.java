package com.texas.ams.repo;

import com.texas.ams.model.Student;
import com.texas.ams.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceReportRepo extends JpaRepository<StudentAttendance,Integer> {
    @Query(
            nativeQuery = true,
            value = "select * from attendance_sheet where attendance_date= ?1"
    )
    List<StudentAttendance> findAttendaceByDate(LocalDate date);
}
