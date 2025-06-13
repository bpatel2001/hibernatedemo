package com.bpatel2001.hibernatedemo.dao;

import com.bpatel2001.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//Specialized annotation for repositories, supports component scanning and translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{
//  Define field for entity manager
    private EntityManager entityManager;
//  Inject entity manager using constructor injection
    @Autowired //Optional as the class only has one constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//  Implement save method
    @Override
    @Transactional //Added since we are saving/storing an object in the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

//   Implement finding and returning a student by ID
    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

//  Implement finding all students and returning them
    @Override
    public List<Student> findAll() {
//      Create query based on the name of the JPA entity, which is the class name. Also ordered by firstName in ascending order
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName asc", Student.class);

//      Return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
//      Create query to find a student based on their last name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

//      Set query parameters
        theQuery.setParameter("theData", lastName);

//      Return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
//      Retrieve the student
        Student theStudent = entityManager.find(Student.class, id );
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }


}
