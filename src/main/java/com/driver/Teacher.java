package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String name;
    private int numberOfStudents;
    private int age;
    private List<Student> studentList = new ArrayList<>();

    // public Teacher(String name) {
    // this.name = name;
    // }

    // public Teacher(String name, int age) {
    // this.name = name;
    // this.age = age;
    // }

    public Teacher(String name, int numberOfStudents, int age) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getAge() {
        return age;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}