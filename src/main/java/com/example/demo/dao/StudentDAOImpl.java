package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
//@Lazy
public class StudentDAOImpl implements StudentDAO {

    // Using @PersistenceContext as entitymanager is managed by JPA and spring automatically injects one without constructor
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Student student) {
        this.em.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        em.remove(student);
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByFName(String firstName) {
        TypedQuery<Student> query = em.createQuery("FROM Student WHERE firstName = :firstName", Student.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}
