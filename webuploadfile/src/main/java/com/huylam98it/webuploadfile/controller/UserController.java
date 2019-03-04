package com.huylam98it.webuploadfile.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huylam98it.webuploadfile.service.FileService;

@Controller
public class UserController {

	@Autowired
	FileService fileService;

	@GetMapping(value = "/user")
	public String userPage() {
		return "user";
	}

	@PostMapping(value = "/userupload")
	public @ResponseBody ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile[] files,
			Principal principal) {
		System.out.println("da vao upload file");
		int sl = 0;
		String username = principal.getName();
		if (username != null) {
			for (MultipartFile f : files) {
				try {
					fileService.uploadFile(f, username);
				} catch (IllegalStateException e) {
					sl++;
				} catch (IOException e) {
					sl++;
				}
			}
			String message = "xay ra " + sl + " loi";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("khong thanh cong", HttpStatus.BAD_REQUEST);
		}
	}
}
