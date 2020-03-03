package com.metacube.assignment8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment8.dao.StudentDao;
import com.metacube.assignment8.model.Student;
import com.metacube.assignment8.serviceimpl.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	/*
	 * This method is used to call the addStudent method of Dao class.
	 */
	@Autowired
	public StudentDao studentDao;

	public boolean addStudent(Student newStudent) {
		return studentDao.addStudent(newStudent);
	}

	/*
	 * This method is used to call the getAllStudent method of Dao class.
	 */
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
}
