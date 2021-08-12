package com.homework.springhomework.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {
    private String name;
    private short age;
    private Gender gender;

    @Override
    public String toString() {
        return "Student name: " + name + ", gender:" + gender.getValue() + ", age:" + age;
    }

}
