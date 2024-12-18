package com.example.demo.service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentDAOImpl;
import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAOImpl theStudentDAO){
        studentDAO = theStudentDAO;
    }

//     define @PostConstruct to load the student data ... only once!
//    @PostConstruct
//    private void loadData() {
//
//        studentDAO.save(new Student("Poornima", "Patel", "ppatel@lol.com"));
//        studentDAO.save(new Student("Mario", "Rossi", "mrossi@lol.com"));
//        studentDAO.save(new Student("Mary", "Smith", "msmith@lol.com"));
//    }

    //Return a Student Name by id
    public String getName(int id) {
        Student student = studentDAO.findById(id);
        return student.getFirstName() + " " + student.getLastName();
    }

    //Return Student by id
    public Student getStudent(int id) {
        return studentDAO.findById(id);
    }

    //Saves student object
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDAO.save(student);
    }

    // Updates the student object
    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    // Deletes student by id
    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.delete(getStudent(id));
    }

    //Returns list of all Student objects
    public List<Student> getStudent() {
        return studentDAO.findAll();
    }

    // Returns list of all students by firstname
    public List<Student> getStudentByFirstName(String firstName) {
        return studentDAO.findByFName(firstName);
    }
}
