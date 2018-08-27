package com.example.entity;

public class Student {
    private String realname;
    private String studentID;
    private String username;
    private String password;

    public Student(String realname, String studentID,String username, String password) {
        this.realname=realname;
        this.studentID=studentID;
        this.username=username;
        this.password=password;
    }

    public Student(){

    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
