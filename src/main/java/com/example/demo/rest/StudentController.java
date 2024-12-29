package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
//import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService thestudentService) {
        studentService = thestudentService;
    }

    @GetMapping("/id")
    public List<Student> getAllStudents() {
        return studentService.getStudent();
    }

    @GetMapping("/id/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/name/{id}")
    public String getStudentName(@PathVariable int id) {
        return studentService.getName(id);
    }

    @PostMapping("/")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setRollNo(id);
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.NO_CONTENT);
    }

}
