package com.huylam98it.webuploadfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.huylam98it.webuploadfile.dao.CustomerDao;
import com.huylam98it.webuploadfile.dao.RoleDao;
import com.huylam98it.webuploadfile.model.Customer;

@Controller
public class RegisterController {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleDao roleDao;

	@PostMapping(value = "/register")
	public String actionRegister(@ModelAttribute() Customer customer) {
		customer.setCusPassword(passwordEncoder.encode(customer.getCusPassword()));
		customer.setRoleBean(roleDao.findById(2).get());
		try {
			customerDao.save(customer);
			return "redirect:login?err=OK";
		} catch (Exception e) {
			return "redirect:login?err=BAD";
		}
	}
}
