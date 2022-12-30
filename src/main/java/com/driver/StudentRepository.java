package com.driver;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer, Student> studentDB = new HashMap<>();
    HashMap<Integer, Teacher> teacherDB = new HashMap<>();
    HashMap<Teacher, List<Student>> pairDB = new HashMap<>();
    int studentNo = 0;
    int teacherNo = 0;

    String addStudentToDb(Student student) {

        studentNo++;

        // Add it to the studentDB
        studentDB.put(studentNo, student);

        return "Successfully added";
    }

    String addTeacherToDb(Teacher teacher) {

        teacherNo++;

        // Add it to the studentDB
        teacherDB.put(teacherNo, teacher);

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
