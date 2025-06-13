package com.bpatel2001.hibernatedemo;

import com.bpatel2001.hibernatedemo.dao.StudentDAO;
import com.bpatel2001.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Bean
//	Will be executed after the Spring Beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		Java Lambda Expression
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
//		Create the student object

		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

//		Save the student object

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		Display ID of the saved student

		System.out.println("Saved student. Generated ID: " + tempStudent.getId());
	}
}
