package com.metacube.assignment8.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.assignment8.model.Student;

@Repository
public class StudentDao {

	private static List<Student> studentsList = new ArrayList<>();
	private static int counter = 1;

	/*
	 * This function is used to add the student to database
	 */
	public boolean addStudent(Student newStudent) {
		newStudent.setId(counter);
		studentsList.add(newStudent);
		counter++;
		return true;
	}

	/*
	 * This function is used to get the student data from the database
	 */
	public List<Student> getAllStudents() {
		return studentsList;
	}

}
