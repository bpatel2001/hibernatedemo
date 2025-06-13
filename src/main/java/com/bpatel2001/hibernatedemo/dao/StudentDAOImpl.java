package com.bpatel2001.hibernatedemo.dao;

import com.bpatel2001.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Specialized annotation for repositories, supports component scanning and translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{
//  Define field for entity manager
    private EntityManager entityManager;
//  Inject entity manager using constructor injection
    @Autowired //Optional
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//  Implement save method

    @Override
    @Transactional //Added since we are saving/storing an object in the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
