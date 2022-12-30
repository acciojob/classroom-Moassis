package com.driver;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // This is a way of telling java ---> this is the service layer
public class StudentService {

    @Autowired // Its used to connect the different classes via object
    StudentRepository studentRepository; // Assume object is already created

    String addStudent(Student student) {

        // This is the service layer
        String result = studentRepository.addStudentToDb(student);
        return result;
    }

    String addTeacher(Teacher teacher) {

        // This is the service layer
        String result = studentRepository.addTeacherToDb(teacher);
        return result;
    }

    String addPair(String student, String teacher) {

        // This is the service layer
        String result = studentRepository.addPairToDb(student, teacher);
        return result;
    }

    Student getStudentByName(String name) {

        // Calling the repo Layer
        Student student = studentRepository.getStudentFromDb(name);
        return student;
    }

    Teacher getTeacherByName(String name) {

        // Calling the repo Layer
        Teacher teacher = studentRepository.getTeacherFromDb(name);
        return teacher;
    }

    List<String> getStudentList(String teacher) {
        List<String> studentNameList = studentRepository.getStudentList(teacher);
        return studentNameList;
    }

    List<String> getAllStudentList() {
        List<String> studentList = studentRepository.getAllStudentList();
        return studentList;
    }

    void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
        return;
    }

    void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
        return;
    }

}
