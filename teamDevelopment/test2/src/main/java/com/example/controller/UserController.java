package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Controller
public class UserController{
	private final UserRepository repository;

	@Autowired
	public UserController(UserRepository repository){
        this.repository = repository;
    }
	@GetMapping("/")
	public String home(@ModelAttribute User user) {
		return "form";
	}
	@PostMapping("/form")
	public String result(@Validated
	@ModelAttribute User user,
	BindingResult result){
		if(result.hasErrors()) {
			return "form";
		}
		repository.save(user);
		return "result";
	}
}
