package com.huylam98it.webuploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String loginPage(@RequestParam(required = false) String err, Model model) {
		if (err != null) {
			if (err.equals("fail")) {
				System.out.println("da vao day");
				model.addAttribute("message", "Thông tin đăng nhập không chính xác");
			} else if (err.equals("OK")) {
				model.addAttribute("message", "đăng ký thành công, hãy đăng nhập");
			} else if (err.equals("BAD")) {
				model.addAttribute("message", "đăng ký không thành công");
			}
		}
		return "login";
	}

}
