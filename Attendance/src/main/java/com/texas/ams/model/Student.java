package com.texas.ams.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean isPresent=false;   //to set the default value to false

    public Student(Integer id, String name, String address, Boolean isPresent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isPresent = isPresent;
    }

    public Student(String name, String address, Boolean isPresent) {
        this.name = name;
        this.address = address;
        this.isPresent = isPresent;
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

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void getAddress(String address) {
        this.address = address;
    }

    public void getPresent(Boolean present) {
        isPresent = present;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
