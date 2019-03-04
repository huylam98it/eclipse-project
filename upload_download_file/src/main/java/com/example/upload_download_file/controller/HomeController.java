package com.example.upload_download_file.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;

	@GetMapping(value = "/")
	public String home(Model model) throws FileNotFoundException {
		System.out.println("home page");
		String folderUpName = context.getRealPath("/file");
		System.out.println(folderUpName);
		File folderUp = new File(folderUpName);
		if (!folderUp.exists()) {
			folderUp.mkdirs();
		}
		List<File> files = new ArrayList<File>();
		for (File f : folderUp.listFiles()) {
			System.out.println("filename: " + f.getName());
			files.add(f);
		}
		model.addAttribute("files", files);
		return "home";
	}
}
