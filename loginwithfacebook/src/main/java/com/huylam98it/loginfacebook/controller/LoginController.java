package com.huylam98it.loginfacebook.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huylam98it.loginfacebook.MyComponent;

@Controller
public class LoginController {

	@Autowired
	MyComponent mycom;

	@GetMapping(value = "/")
	public String homePage() {
		return "home";
	}

	@GetMapping(value = "/login")
	public String loginPage() {
		return "loginpage";
	}

	@GetMapping(value = "/login-facebook")
	public String actionLogin(@RequestParam("code") String code, RedirectAttributes red) {
		System.out.println(code);
		try {
			String token = mycom.getAsscesToken(code);
			System.out.println(token);
			String user = mycom.getUser(token);
			red.addAttribute("user", user);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/user";
	}

	@GetMapping(value = "/user")
	public String actionLogin2(@RequestParam(required = false) String user, Model model) {
		model.addAttribute("user", user);
		return "user";
	}
}
