package com.homework.springhomework.repositories;

import com.homework.springhomework.models.student.Gender;
import com.homework.springhomework.models.student.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> studentList=new ArrayList<>();

    @PostConstruct
    void addSampleStudentsToRepo() {
        studentList.add(new Student("Pawel", (short) 21, Gender.MALE));
        studentList.add(new Student("Roman", (short) 23, Gender.MALE));
        studentList.add(new Student("Aleksandra", (short) 21, Gender.FEMALE));
        studentList.add(new Student("Krystyna", (short) 24, Gender.FEMALE));
        studentList.add(new Student("Pawel", (short) 25, Gender.MALE));
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

}
