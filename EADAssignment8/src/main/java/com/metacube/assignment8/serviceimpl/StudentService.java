package com.metacube.assignment8.serviceimpl;

import java.util.List;

import com.metacube.assignment8.model.Student;

public interface StudentService {

	boolean addStudent(Student newstudent);

	List<Student> getAllStudents();

}
