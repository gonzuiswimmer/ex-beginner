package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.form.UserForm;
import com.example.exbeginner.model.User;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("exam04")

public class Exam04Controller {
  @GetMapping({"","/"})
  public String index(UserForm form, Model model) {
    return "exam04";
  }

  @PostMapping("/profile")
  public String profile(@Validated UserForm form, BindingResult rs, Model model) {
    if(rs.hasErrors()){
      return index(form, model);
    }

    User user = new User();
    user.setName(form.getName());
    user.setAge(form.getAge());
    user.setComment(form.getComment());
    model.addAttribute("user", user);

    return "exam04-result";
  }
  
  
}
