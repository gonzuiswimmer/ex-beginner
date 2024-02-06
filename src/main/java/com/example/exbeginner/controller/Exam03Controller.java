package com.example.exbeginner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("exam03")

public class Exam03Controller {

  @Autowired
  private ServletContext application;


  @GetMapping({"","/"})
  public String index() {
    return "exam03";
  }
  @PostMapping("/buy")
  public String buy(Integer item1, Integer item2, Integer item3) {
    int total_price = item1 + item2 + item3;
    int included_tax_price = (int) (total_price * 1.08);
    application.setAttribute("total_price", total_price);
    application.setAttribute("included_tax_price", included_tax_price);

    return "exam03-result";
  }
    
}
