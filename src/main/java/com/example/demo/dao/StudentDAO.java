package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    void update(Student student);
    void delete(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByFName(String firstName);

}
