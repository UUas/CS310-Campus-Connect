package com.example.campusconnect10;

import java.io.Serializable;

public class Users implements Serializable {
    private String userId;

    private String userName;
    private String name;
    private String surName;
    private String studentClub;
    private String password;
    private int age;
    private String faculty;

    public Users() {
        // TODO Auto-generated constructor stub
    }


    // Constructor with all variables
    public Users(String userId, String userName, String name, String surName, String studentClub, String password, int age, String faculty) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.studentClub = studentClub;
        this.password = password;
        this.age = age;
        this.faculty = faculty;
    }

    // Constructor without userId
    public Users(String userName, String name, String surName, String studentClub, String password, int age, String faculty) {
        super();
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.studentClub = studentClub;
        this.password = password;
        this.age = age;
        this.faculty = faculty;
    }

// Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getStudentClub() {
        return studentClub;
    }

    public void setStudentClub(String studentClub) {
        this.studentClub = studentClub;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "User [eventId=" + userId + ", userName=" + userName + ", name=" + name + ", surname=" + surName
                + ", studentClub=" + studentClub + ", password=" + password + ", age=" + age + ", faculty=" + faculty + "]";
    }
}
