package com.bpatel2001.hibernatedemo;

import com.bpatel2001.hibernatedemo.dao.StudentDAO;
import com.bpatel2001.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
//		Get a list of students

		List<Student> theStudents = studentDAO.findByLastName("Doe");

//		Display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
//		Get a list of students
		List<Student> theStudents = studentDAO.findAll();

//		Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
//		Create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Bruh", "Patel", "bruh@gmail.com");

//		Save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		Display ID of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

//		Retrieve student based on the ID: Primary key;
		System.out.println("Retrieving student with id " + theId);
		Student myStudent = studentDAO.findByID(theId);

//		Display Student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		Create multiple students
		System.out.println("Creating 4 new student objects...");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@gmail.com");
		Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent3 = new Student("Bhavik", "Doe", "bhavik@gmail.com");
		Student tempStudent4 = new Student("Jane", "Doe", "jane@gmail.com");

//		Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

//		Display ID of saved students
		System.out.println("Saved student 1. Generated ID: " + tempStudent1.getId());
		System.out.println("Saved student 2. Generated ID: " + tempStudent2.getId());
		System.out.println("Saved student 3. Generated ID: " + tempStudent3.getId());
		System.out.println("Saved student 4. Generated ID: " + tempStudent4.getId());


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
