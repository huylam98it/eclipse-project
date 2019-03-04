package com.huylam98it.webuploadfile.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = { "/home" })
	public String homePage(Principal principal, Authentication auth) {
		System.out.println(principal.getName());
		String grant = auth.getAuthorities().toString();
		if (grant.contains("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		return "redirect:/user";
	}

	@GetMapping(value = "/")
	public String home() {
		return "redirect:user";
	}
}
