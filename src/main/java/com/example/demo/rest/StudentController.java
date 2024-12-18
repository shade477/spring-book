package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
//import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/id/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

}
