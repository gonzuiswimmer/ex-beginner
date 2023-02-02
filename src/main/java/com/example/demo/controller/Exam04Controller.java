package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domein.User;
import com.example.demo.form.Exam04Form;

@Controller
@RequestMapping("/ex04")
public class Exam04Controller {

	@GetMapping("")
	public String index(Exam04Form exam04Form, Model model) {
		return "exam04";
	}

	@PostMapping("registerProfile")
	public String registerProfile(@Validated Exam04Form exam04Form, BindingResult result,
			RedirectAttributes redirectattributes, Model model) {
		if (result.hasErrors()) {
			return index(exam04Form, model);
		}

		User user = new User();
		user.setName(exam04Form.getName());
		user.setAge(exam04Form.getIntAge());
		user.setComment(exam04Form.getComment());
		redirectattributes.addFlashAttribute("user", user);
		return "redirect:/ex04/toresult";
	}

	@GetMapping("/toresult")
	public String toresult() {
		return "exam04-result";
	}
}
