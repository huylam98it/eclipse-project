package com.example.upload_download_file.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.upload_download_file.dao.FileDao;

@Controller
public class UploadFileController {

	@Autowired
	ServletContext context;

	@Autowired
	FileDao fileDao;

	@PostMapping(value = "/uploadfile")
	public String uploadFile(@RequestParam("myfile") MultipartFile[] files) throws IllegalStateException, IOException {

		for (MultipartFile f : files) {
			upLoad(f);
		}
		return "redirect:/";
	}

	public void upLoad(MultipartFile file) throws IllegalStateException, IOException {
		com.example.upload_download_file.model.File fe = fileDao.getFileByName(file.getOriginalFilename());
		if (fe == null) {
			String folderUpName = context.getRealPath("/file");
			System.out.println(folderUpName);
			File folderUp = new File(folderUpName);
			if (!folderUp.exists()) {
				folderUp.mkdirs();
			}
			String fTam = folderUp.getAbsolutePath() + "/" + file.getOriginalFilename();
			System.out.println(fTam);
			File fl = new File(fTam);
			file.transferTo(fl);
		}
	}
}
