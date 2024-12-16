package com.example.demo.service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentDAOImpl;
import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> theStudents;
    private StudentDAO studentDAO;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    private void loadData() {

        studentDAO.save(new Student("Poornima", "Patel"));
        studentDAO.save(new Student("Mario", "Rossi"));
        studentDAO.save(new Student("Mary", "Smith"));
    }

    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
    }

    public String getName(int id) {
        Student student = studentDAO.findById(id);
        return student.getFName() + " " + student.getLName();
    }

    public Student getStudent(int id) {
        return studentDAO.findById(id);
    }


}
