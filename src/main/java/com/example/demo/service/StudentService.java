package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    String getName(int id);
    List<Student> getStudent();
    Student getStudent(int id);
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
