package com.example.exbeginner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.model.Member;
import com.example.exbeginner.repository.MemberRepository;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("exam05")
public class Exam05Controller {
  @Autowired
  private MemberRepository repository;

  @GetMapping({"","/"})
  public String index() {
    return "exam05";
  }

  @PostMapping("/search")
  public String search(String keyword, Model model) {
    List<Member> member_list  = repository.ambiguousSearch(keyword);

    model.addAttribute("member_list", member_list);
    System.out.println(member_list);
    return "exam05-result";
  }
  
  
}
