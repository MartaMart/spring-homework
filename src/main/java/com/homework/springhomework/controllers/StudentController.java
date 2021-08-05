package com.homework.springhomework.controllers;

import com.homework.springhomework.exceptions.StudentNotFoundException;
import com.homework.springhomework.models.student.Gender;
import com.homework.springhomework.models.student.Student;
import com.homework.springhomework.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    public final StudentService studentService;

    //CREATE
    @PostMapping("/add") // /api/students/add?name=Jacek&age=23&genderValue=m
    public void addStudent(@RequestParam String name, @RequestParam short age, @RequestParam String genderValue) {
        Gender gender = Gender.getGenderFromValue(genderValue);
        studentService.addStudent(name, age, gender);
    }

    //READ
    @GetMapping // /api/students
    public List<Student> getAllStudents() {
        return studentService.displayAllStudents();
    }

    @GetMapping("{id}") // /api/students/1
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.displayStudentById(id).orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping("/name/{name}") // /api/students/name/pawel
    public List<Student> getStudentByName(@PathVariable("name") String name) {
        return studentService.displayStudentsByName(name).orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping("/gender")//    /api/students/gender?g=m
    public List<Student> getStudentsByGender(@RequestParam String g) {
        return studentService.displayStudentsByGender(g).orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping("/age/{age}") // /api/students/age/23
    public List<Student> getStudentsByAge(@PathVariable short age) {
        return studentService.displayStudentsByAge(age).orElseThrow(StudentNotFoundException::new);
    }

    //UPDATE
    @PutMapping("/{id}") // /api/students/1?newName=Karol&newAge=20&newGender=m
    public void updateStudent(@PathVariable int id, @RequestParam String newName, @RequestParam short newAge,
                              @RequestParam String newGender) {
        studentService.updateStudentById(id, newName, newAge, newGender);
    }

    //DELETE
    @DeleteMapping("/{id}") // /api/students/1
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
