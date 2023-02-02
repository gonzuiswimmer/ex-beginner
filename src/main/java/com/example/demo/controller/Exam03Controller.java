package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Exam03Form;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String index(Model model, ServletContext application, Exam03Form form) {
		int excludingTax = form.getItem1Price() + form.getItem2Price() + form.getItem3Price();
		application.setAttribute("excludingTax", excludingTax);
		int includingTax = (int) (excludingTax * 1.08);
		application.setAttribute("includingTax", includingTax);
		return "exam03";
	}

	@PostMapping("calcTax")
	public String calcTax() {
		return "exam03-result";
	}
}
