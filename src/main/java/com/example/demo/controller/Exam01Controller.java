package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Exam01Form;

@Controller
@RequestMapping("/ex01")

public class Exam01Controller {
	@GetMapping("")
	public String index(Model model, Exam01Form form) {
		return "exam01";
	}
	@PostMapping("/create")
	public String create(Model model, Exam01Form form) {
		
		model.addAttribute("name",form.getName());
		return "exam01-result";
	}
}
