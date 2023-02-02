package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Exam02Form;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("ex02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;

	@GetMapping("")
	public String index(Model model, Exam02Form form) {
		return "exam02";
	}

	@PostMapping("/calc")
	public String calc(Model model, Exam02Form form, HttpSession session) {
		int sum = form.getNum1() + form.getNum2();
		session.setAttribute("num1", form.getNum1());
		session.setAttribute("num2", form.getNum2());
		session.setAttribute("sum", sum);
		return "exam02-result";
	}

	@GetMapping("/toresult")
	public String toresult(Model model) {
		return "exam02-result2";
	}

}
