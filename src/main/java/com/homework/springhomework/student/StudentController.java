package com.homework.springhomework.student;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
class StudentController {

    public final StudentService studentService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.displayAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.displayStudentById(id);
    }

    @GetMapping("/name")
    public List<Student> getStudentsByName(@RequestParam String n) {
        return studentService.displayStudentsByName(n);
    }

    @GetMapping("/gender")
    public List<Student> getStudentsByGender(@RequestParam String g) {
        return studentService.displayStudentsByGender(g);
    }

    @GetMapping("/age")
    public List<Student> getStudentsByAge(@RequestParam short a) {
        return studentService.displayStudentsByAge(a);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Integer id,
                              @RequestParam(required = false, value = "name") String newName, @RequestParam(required
            = false, value = "age") Short newAge, @RequestParam(required = false, value = "gender") String newGender) {
        studentService.updateStudentById(id, newName, newAge, newGender);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
