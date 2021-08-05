package com.homework.springhomework.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("Student doesn't exist.");
    }

//    public StudentNotFoundException(String name) {
//        super("Student with name "+name+" does not exist.");
//    }
}
