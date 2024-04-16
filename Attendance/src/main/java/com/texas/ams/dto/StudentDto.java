package com.texas.ams.dto;

public class StudentDto {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private String fatherName;
    private String motherName;
    private String phone;
    private String email;
    private String gender;

    public StudentDto(Integer id, String name, String address, Integer age, String fatherName, String motherName, String phone, String email, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public StudentDto(String name, String address, Integer age, String fatherName, String motherName, String phone, String email, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
