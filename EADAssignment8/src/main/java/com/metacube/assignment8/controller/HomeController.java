package com.metacube.assignment8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.assignment8.model.Student;

@Controller
public class HomeController {

	public String message = "Welcome!!";

	/*
	 * This method display the home page
	 */
	@GetMapping({ "/", "/home" })
	public String displayHomePage(Model model) {
		model.addAttribute("message", message);
		return "homePage";

	}

	/*
	 * This mehod is used to call addStudent html page and send the Student data.
	 */
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
}
