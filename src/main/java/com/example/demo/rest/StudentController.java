package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
//import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService thestudentService) {
        studentService = thestudentService;
    }

    @GetMapping("/id/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/name/{id}")
    public String getStudentName(@PathVariable int id) {
        return studentService.getName(id);
    }

}
