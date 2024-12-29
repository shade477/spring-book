package com.example.demo.dao;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Integer> {
    // JPARepository will create basic JPA functions
}
