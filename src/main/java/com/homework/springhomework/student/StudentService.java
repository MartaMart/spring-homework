package com.homework.springhomework.student;

import com.homework.springhomework.exceptions.StudentNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    void addStudent(Student student) {
        studentRepository.addNewStudent(student);
        log.info("Student was added to database.");
    }

    List<Student> displayAllStudents(){
        Optional<List<Student>> allStudents = studentRepository.getAllStudents();
        if (allStudents.isPresent()){
            if (allStudents.get().size()!=0) {
                log.info("All students were displayed.");
                return allStudents.get();
            } else {
                throw new StudentNotFoundException("The list of students is empty.");
            }
        }
        return null;
    }

    Student displayStudentById(Integer id) {
        Optional<Student> studentById = studentRepository.getStudentById(id);
        if (studentById.isPresent()){
            log.info("Student with id: "+id+" was displayed.");
            return studentById.get();
        } else {
            throw new StudentNotFoundException("There's no such student with id: "+id);
        }
    }

    List<Student> displayStudentsByName(String name) {
        Optional<List<Student>> studentByName = studentRepository.getStudentsByName(name);
        Optional<List<Student>> allStudents = studentRepository.getAllStudents();
        if (allStudents.isPresent() && allStudents.get().size()!=0 && studentByName.isPresent()){
            log.info("Students with name: "+name+" were displayed.");
            return studentByName.get();
        } else {
            throw new StudentNotFoundException("There's no such student with name: "+name);
        }
    }

    List<Student> displayStudentsByAge(short age) {
        Optional<List<Student>> studentByAge = studentRepository.getStudentsByAge(age);
        Optional<List<Student>> allStudents = studentRepository.getAllStudents();
        if (allStudents.isPresent() && allStudents.get().size()!=0 && studentByAge.isPresent()){
            log.info("Students with age: "+age+" were displayed.");
            return studentByAge.get();
        } else {
            throw new StudentNotFoundException("There's no such student with age: "+age);
        }
    }

    List<Student> displayStudentsByGender(String gender) {
        Gender genderFromValue = Gender.getGenderFromValue(gender);
        Optional<List<Student>> studentByGender = studentRepository.getStudentsByGender(genderFromValue);
        Optional<List<Student>> allStudents = studentRepository.getAllStudents();
        if (allStudents.isPresent() && allStudents.get().size()!=0 && studentByGender.isPresent()){
            log.info("All "+genderFromValue+" students were displayed.");
            return studentByGender.get();
        } else {
            throw new StudentNotFoundException("There's no such student with gender: "+genderFromValue);
        }
    }

    void updateStudentById(Integer id, String name, Short age, String gender){
        Optional<Student> studentById = studentRepository.getStudentById(id);
        studentById.orElseThrow(()->new StudentNotFoundException("There's no such student with id: "+id));

        if (name==null){
            name= studentById.get().getName();
        }
        if (age==null){
            age= studentById.get().getAge();
        }
        if (gender==null){
            gender= studentById.get().getGender().getValue();
        }

        String studentNameForGivenId = studentById.get().getName();
        boolean isStudentNameSameAsGivenToChange = Objects.equals(name, studentNameForGivenId);
        if (!isStudentNameSameAsGivenToChange && !name.isEmpty() && !name.isBlank()){
            studentById.get().setName(name);
        }

        short studentAgeForGivenId = studentById.get().getAge();
        boolean isStudentAgeSameAsGivenToChange = Objects.equals(age, studentAgeForGivenId );
        if (!isStudentAgeSameAsGivenToChange && age>0){
            studentById.get().setAge(age);
        }

        Gender studentGenderForGivenId = studentById.get().getGender();
        Gender genderFromValue = Gender.getGenderFromValue(gender);
        boolean isStudentGenderSameAsGivenToChange = Objects.equals(genderFromValue, studentGenderForGivenId);
        if (!isStudentGenderSameAsGivenToChange){
            studentById.get().setGender(genderFromValue);
        }

        log.info("Student with id: " + id + " was updated.");
    }

    void deleteStudent(Integer id){
        Optional<Student> studentById = studentRepository.getStudentById(id);
        studentById.orElseThrow(()->new StudentNotFoundException("There's no such student with id: "+id));
        Optional<List<Student>> allStudents = studentRepository.getAllStudents();
        if (allStudents.isPresent()){
            List<Student> studentList = allStudents.get();
            studentList.remove(studentById.get());
            log.info("Student with id: " + id + " was removed.");
        }
    }


    //UPDATE
//    public Optional<Student> updateStudentById(int id, String newName, short newAge, String newGender) {
//        try {
//            Student studentToUpdate = studentRepository.getAllStudent().get(id);
//            studentToUpdate.setName(newName);
//            studentToUpdate.setAge(newAge);
//            Gender genderToUpdate = Gender.getGenderFromValue(newGender);
//            studentToUpdate.setGender(genderToUpdate);
//            log.info("Student with id: " + id + " was updated.");
//            return Optional.of(studentToUpdate);


    //DELETE
//    public Optional<Student> deleteStudent(int id) {
//        try {
//            Student studentToDelete = studentRepository.getAllStudent().get(id);
//            studentRepository.getAllStudent().remove(studentToDelete);
//            log.info("Student with id:" + id + " was deleted.");
//            return Optional.of(studentToDelete);
//        } catch (StudentNotFoundException e) {
//            return Optional.empty();
//        }
//    }

}
