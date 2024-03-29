package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("exam02")
public class Exam02Controller {
  @GetMapping({"","/"})
  public String index() {
      return "exam02";
  }

  @PostMapping("calc")
  public String calc(Integer num1, Integer num2, Model model) {
    int total = num1 + num2;
    model.addAttribute("total", total).addAttribute("num1", num1).addAttribute("num2", num2);
    return "exam02-result";
  }
  
}
