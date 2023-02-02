package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Exam03Form;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	@GetMapping("")
	public String index(Exam03Form form) {
		
		
		
		return "exam03";

	}

	@PostMapping("calcTax")
	public String calcTax(Exam03Form form) {
		int excludingTaxPrice = form.getItem1Price() + form.getItem2Price() + form.getItem3Price();
		application.setAttribute("excludingTaxPrice", excludingTaxPrice);
		int includingTaxPrice = (int) (excludingTaxPrice * 1.08);
		application.setAttribute("includingTaxPrice", includingTaxPrice);
		return "exam03-result";
	}
}
