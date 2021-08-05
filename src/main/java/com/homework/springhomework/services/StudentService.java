package com.homework.springhomework.services;

import com.homework.springhomework.exceptions.StudentNotFoundException;
import com.homework.springhomework.models.student.Gender;
import com.homework.springhomework.models.student.Student;
import com.homework.springhomework.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    //CREATE
    public Student addStudent(String name, short age, Gender gender) {
        Student studentToAdd = new Student(name, age, gender);
        studentRepository.getAllStudent().add(studentToAdd);
        log.info("Student was added to DB.");
        return studentToAdd;
    }

    //READ
    public List<Student> displayAllStudents() {
        log.info("All students was displayed.");
        return studentRepository.getAllStudent();
    }

    public Optional<Student> displayStudentById(Integer id) {
        try {
            return Optional.of(studentRepository.getAllStudent().get(id));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public Optional<List<Student>> displayStudentsByName(String name) {
        try {
            return Optional.of(studentRepository.getAllStudent().stream().filter(student -> student.getName().equalsIgnoreCase(name)).collect(Collectors.toList()));
        } catch (StudentNotFoundException e) {
            return Optional.empty();
        }
    }

    public Optional<List<Student>> displayStudentsByAge(short age) {
        try {
            return Optional.of(studentRepository.getAllStudent().stream().filter(student -> student.getAge() == age).collect(Collectors.toList()));
        } catch (StudentNotFoundException e) {
            return Optional.empty();
        }

    }

    public Optional<List<Student>> displayStudentsByGender(String genderValue) {
        try {
            Gender gender = Gender.getGenderFromValue(genderValue);
            return Optional.of(studentRepository.getAllStudent().stream().filter(s -> s.getGender() == gender).collect(Collectors.toList()));
        } catch (StudentNotFoundException e) {
            return Optional.empty();
        }
    }

    //UPDATE
    public Optional<Student> updateStudentById(int id, String newName, short newAge, String newGender) {
        try {
            Student studentToUpdate = studentRepository.getAllStudent().get(id);
            studentToUpdate.setName(newName);
            studentToUpdate.setAge(newAge);
            Gender genderToUpdate = Gender.getGenderFromValue(newGender);
            studentToUpdate.setGender(genderToUpdate);
            log.info("Student with id: " + id + " was updated.");
            return Optional.of(studentToUpdate);
        } catch (StudentNotFoundException e) {
            return Optional.empty();
        }
    }

    //DELETE
    public Optional<Student> deleteStudent(int id) {
        try {
            Student studentToDelete = studentRepository.getAllStudent().get(id);
            studentRepository.getAllStudent().remove(studentToDelete);
            log.info("Student with id:" + id + " was deleted.");
            return Optional.of(studentToDelete);
        } catch (StudentNotFoundException e) {
            return Optional.empty();
        }
    }

}
