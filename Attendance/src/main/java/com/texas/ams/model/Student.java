package com.texas.ams.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name="DOB", nullable = false)
    private Integer age;

    @Column(name="Father's Name", nullable = false)
    private String fatherName;

    @Column(name="Mother's Name", nullable = false)
    private String motherName;

    @Column(name="Phone No.", nullable = false)
    private String phone;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Gender", nullable = false)
    private String gender;

    public Student(Integer id, String name, String address, Integer age, String fatherName, String motherName, String phone, String email, String gender) {
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

    public Student(String name, String address, Integer age, String fatherName, String motherName, String phone, String email, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public Student() {
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
