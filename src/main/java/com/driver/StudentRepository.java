package com.driver;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDB = new HashMap<>();
    HashMap<String, Teacher> teacherDB = new HashMap<>();
    HashMap<Teacher, List<Student>> pairDB = new HashMap<>();

    String addStudentToDb(Student student) {

        String name = student.getName();

        // Add it to the studentDB
        studentDB.put(name, student);

        return "Successfully added";
    }

    String addTeacherToDb(Teacher teacher) {

        String name = teacher.getName();

        // Add it to the studentDB
        teacherDB.put(name, teacher);

        return "Successfully added";
    }

    String addPairToDb(String student, String teacher) {

        // Add it to the studentDB
        Student st = null;
        for (Student s : studentDB.values()) {
            if (s.getName().equals(student)) {
                st = s;
                break;
            }
        }

        Teacher tr = null;
        for (Teacher t : teacherDB.values()) {
            if (t.getName().equals(teacher)) {
                tr = t;
                break;
            }
        }
        List<Student> studentList = tr.getStudentList();
        studentList.add(st);
        pairDB.put(tr, studentList);

        return "Successfully added";
    }

    Student getStudentFromDb(String name) {

        if (studentDB.containsKey(name)) {
            return studentDB.get(name);
        } else
            return null;
    }

    Teacher getTeacherFromDb(String name) {

        if (teacherDB.containsKey(name)) {
            return teacherDB.get(name);
        } else
            return null;
    }

    List<String> getStudentList(String teacher) {

        Teacher tr = null;
        for (Teacher t : teacherDB.values()) {
            if (t.getName().equals(teacher)) {
                tr = t;
                break;
            }
        }
        List<Student> studentList = tr.getStudentList();

        List<String> studentNameList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            studentNameList.add(studentList.get(i).getName());
        }

        return studentNameList;
    }

    List<String> getAllStudentList() {
        List<String> studentList = new ArrayList<>();
        for (Student s : studentDB.values()) {
            String name = s.getName();
            studentList.add(name);
        }
        return studentList;
    }

}
