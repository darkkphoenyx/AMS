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
    private String father_Name;

    @Column(name="Mother's Name", nullable = false)
    private String mother_Name;

    @Column(name="Phone No.", nullable = false)
    private String phone;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Gender", nullable = false)
    private String gender;

    public Student(Integer id, String name, String address, Integer age, String father_Name, String mother_Name, String phone, String email, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.father_Name = father_Name;
        this.mother_Name = mother_Name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public Student(String name, String address, Integer age, String father_Name, String mother_Name, String phone, String email, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.father_Name = father_Name;
        this.mother_Name = mother_Name;
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

    public String getFather_Name() {
        return father_Name;
    }

    public void setFather_Name(String father_Name) {
        this.father_Name = father_Name;
    }

    public String getMother_Name() {
        return mother_Name;
    }

    public void setMother_Name(String mother_Name) {
        this.mother_Name = mother_Name;
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
