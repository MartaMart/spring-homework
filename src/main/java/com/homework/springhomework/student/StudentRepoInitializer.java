package com.homework.springhomework.student;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
class StudentRepoInitializer {

    private final List<Student> studentsList = new ArrayList<>();

    @PostConstruct
    void addSampleStudentsToRepo() {
        studentsList.add(new Student("Pawel", (short) 21, Gender.MALE));
        studentsList.add(new Student("Roman", (short) 23, Gender.MALE));
        studentsList.add(new Student("Aleksandra", (short) 21, Gender.FEMALE));
        studentsList.add(new Student("Krystyna", (short) 24, Gender.FEMALE));
        studentsList.add(new Student("Pawel", (short) 25, Gender.MALE));
    }

    List<Student> getStudentsList() {
        return studentsList;
    }

}
