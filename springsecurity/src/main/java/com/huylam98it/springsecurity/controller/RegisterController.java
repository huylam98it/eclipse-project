package com.huylam98it.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.huylam98it.springsecurity.dao.RoleDao;
import com.huylam98it.springsecurity.dao.UserDao;
import com.huylam98it.springsecurity.model.User;

@Controller(value = "register")
public class RegisterController {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping
	public String register() {
		return "register";
	}

	@PostMapping
	public String doRegister(@ModelAttribute("user") User user) {
		user.setRole(roleDao.findById(2).get());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
		return "redirect:/login";
	}
}
