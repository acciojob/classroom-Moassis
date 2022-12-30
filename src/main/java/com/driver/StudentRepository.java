package com.driver;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDB = new HashMap<>();
    HashMap<String, Teacher> teacherDB = new HashMap<>();
    HashMap<String, List<String>> pairDB = new HashMap<>();

    String addStudentToDb(Student student) {
        String name = student.getName();

        // Add it to the studentDB
        studentDB.put(name, student);

        return "Successfully added";
    }

    String addTeacherToDb(Teacher teacher) {
        // Add it to the studentDB
        String name = teacher.getName();
        teacherDB.put(name, teacher);

        return "Successfully added";
    }

    String addPairToDb(String student, String teacher) {

        // Add it to the studentDB
        List<String> studentList = pairDB.getOrDefault(teacher, new ArrayList<>());
        studentList.add(student);
        pairDB.put(teacher, studentList);

        return "Successfully added";
    }

    Student getStudentFromDb(String name) {

        Student st = null;
        for (Student s : studentDB.values()) {
            if (s.getName().equals(name)) {
                st = s;
                break;
            }
        }
        return st;
    }

    Teacher getTeacherFromDb(String name) {

        Teacher tr = null;
        for (Teacher t : teacherDB.values()) {
            if (t.getName().equals(name)) {
                tr = t;
                break;
            }
        }
        return tr;
    }

    List<String> getStudentList(String teacher) {

        List<String> studentNameList = pairDB.getOrDefault(teacher, new ArrayList<>());

        return studentNameList;
    }

    List<String> getAllStudentList() {
        return new ArrayList<>(studentDB.keySet());
    }

}
