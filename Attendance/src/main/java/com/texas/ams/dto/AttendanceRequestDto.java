package com.texas.ams.dto;

import java.util.List;

public class AttendanceRequestDto {
    private List<Integer> presentStudentIds;
    private List<Integer> absentStudentIds;

    public AttendanceRequestDto(List<Integer> presentStudentIds, List<Integer> absentStudentIds) {
        this.presentStudentIds = presentStudentIds;
        this.absentStudentIds = absentStudentIds;
    }

    public AttendanceRequestDto() {
    }

    public List<Integer> getPresentStudentIds() {
        return presentStudentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.presentStudentIds = studentIds;
    }

    public void setPresentStudentIds(List<Integer> presentStudentIds) {
        this.presentStudentIds = presentStudentIds;
    }

    public List<Integer> getAbsentStudentIds() {
        return absentStudentIds;
    }

    public void setAbsentStudentIds(List<Integer> absentStudentIds) {
        this.absentStudentIds = absentStudentIds;
    }

}
