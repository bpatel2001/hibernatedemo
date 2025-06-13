package com.bpatel2001.hibernatedemo.dao;

import com.bpatel2001.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findByID(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);
}
