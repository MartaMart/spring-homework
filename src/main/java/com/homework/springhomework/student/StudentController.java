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


//    Headers:
//    Accept:application/json
//    Content-type:application/json
//The "Content-Type" header defines which type of content you're sending - not which you want to receive (that's what the "Accept" header is for.

//    Body:
//    {
//        "name":"Kamil",
//        "age":27,
//        "gender":"m"
//    }

    //CREATE
    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE) // /api/students/add
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    //READ
    @GetMapping // /api/students
    public List<Student> getAllStudents() {
        return studentService.displayAllStudents();
    }

    @GetMapping("{id}") // /api/students/1
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.displayStudentById(id);
    }

    @GetMapping("/name") // /api/students/name?n=Jacek
    public List<Student> getStudentsByName(@RequestParam String n) {
        return studentService.displayStudentsByName(n);
    }

    @GetMapping("/gender")//    /api/students/gender?g=m
    public List<Student> getStudentsByGender(@RequestParam String g) {
        return studentService.displayStudentsByGender(g);
    }
    //public void getStudentsByGender(@RequestParam String g)

    @GetMapping("/age") // /api/students/age?a=23
    public List<Student> getStudentsByAge(@RequestParam short a) {
        return studentService.displayStudentsByAge(a);
    }

    //UPDATE
    @PutMapping("/{id}") // /api/students/1?name=Karol&age=20&gender=m
    public void updateStudent(@PathVariable Integer id, @RequestParam(required = false, value = "name") String newName, @RequestParam(required = false, value = "age") Short newAge,
                              @RequestParam(required = false, value="gender") String newGender) {
        studentService.updateStudentById(id, newName, newAge, newGender);
    }

    //DELETE
    @DeleteMapping("/{id}") // /api/students/1
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

}
