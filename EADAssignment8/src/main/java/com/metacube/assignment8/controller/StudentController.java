package com.metacube.assignment8.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.assignment8.model.Student;
import com.metacube.assignment8.service.StudentServiceImp;

@Controller
public class StudentController {

	@Autowired
	public StudentServiceImp studentService;

	/*
	 * This method is used to call service layer addStudent function to add the
	 * student detail
	 */
	@PostMapping("/addStudent")
	public String addStudent(@Valid @ModelAttribute("student") Student student, Errors error) {
		String returnStatement = null;
		if (error.hasErrors()) {
			returnStatement = "addStudent";
		}
		studentService.addStudent(student);
		returnStatement = "redirect:home";
		return returnStatement;

	}

	/*
	 * This method is used to call the showStudent method in service layer to show
	 * all the student
	 */
	@GetMapping("/getAllStudents")
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> studentsList = studentService.getAllStudents();
		modelAndView.setViewName("showStudents");
		modelAndView.addObject("students", studentsList);
		return modelAndView;
	}

}
