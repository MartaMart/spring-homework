package com.homework.springhomework.student;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class StudentRepoInitializer {

    private final List<Student> studentsList = new ArrayList<>();

//    @PostConstruct
//    void addSampleStudentsToRepo() {
//        studentList.add(new Student("Pawel", (short) 21, Gender.MALE));
//        studentList.add(new Student("Roman", (short) 23, Gender.MALE));
//        studentList.add(new Student("Aleksandra", (short) 21, Gender.FEMALE));
//        studentList.add(new Student("Krystyna", (short) 24, Gender.FEMALE));
//        studentList.add(new Student("Pawel", (short) 25, Gender.MALE));
//    }

    List<Student> getStudentsList(){
        return studentsList;
    }

}
