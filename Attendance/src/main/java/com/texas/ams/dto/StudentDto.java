package com.texas.ams.dto;

public class StudentDto {
    private Integer id;
    private String name;
    private String address;
    private Boolean isPresent;

    public StudentDto(Integer id, String name, String address, Boolean isPresent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isPresent = isPresent;
    }

    public StudentDto(String name, String address, Boolean isPresent) {
        this.name = name;
        this.address = address;
        this.isPresent = isPresent;
    }

    public StudentDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

}
