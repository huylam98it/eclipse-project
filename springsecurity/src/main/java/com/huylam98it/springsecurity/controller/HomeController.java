package com.huylam98it.springsecurity.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String homePage(Principal principal, Authentication auth) {
		System.out.println(principal.getName());
		System.out.println(auth.getAuthorities());
		return "home";
	}

	@GetMapping(value = "/admin")
	public String adminPage() {
		return "admin";
	}

	@GetMapping(value = "/403")
	public String pageE() {
		return "403";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

}
