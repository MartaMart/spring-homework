package com.homework.springhomework.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
class StudentRepository {

    private final StudentRepoInitializer studentRepoInitializer;

    void addNewStudent(Student student) {
        studentRepoInitializer.getStudentsList().add(student);
    }

    Optional<List<Student>> getAllStudents() {
        return Optional.of(studentRepoInitializer.getStudentsList());
    }

    Optional<Student> getStudentById(Integer id) {
        try {
            return Optional.of(studentRepoInitializer.getStudentsList().get(id));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    Optional<List<Student>> getStudentsByName(String name) {
        List<Student> nameFilteredStudentList =
                studentRepoInitializer.getStudentsList().stream().filter(student -> student.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return Optional.of(nameFilteredStudentList);
    }

    Optional<List<Student>> getStudentsByAge(short age) {
        return Optional.of(studentRepoInitializer.getStudentsList().stream().filter(student -> student.getAge() == age).collect(Collectors.toList()));
    }

    Optional<List<Student>> getStudentsByGender(Gender gender) {
        return Optional.of(studentRepoInitializer.getStudentsList().stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList()));
    }

}
