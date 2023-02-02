package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex2")
public class Exam02Controller {
	@GetMapping("")
	public String index() {
		return "exam02";
	}
	
	@PostMapping("/calc")
	public String calc() {
		return "exam02-result";
	}
	
	@GetMapping("/toresult")
	public String toresult() {
		return "exam02-result2";
	}
	
}
