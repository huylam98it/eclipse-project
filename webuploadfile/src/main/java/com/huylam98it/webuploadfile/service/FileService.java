package com.huylam98it.webuploadfile.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileService")
public class FileService {

	@Autowired
	ServletContext context;

	public void uploadFile(MultipartFile file, String username) throws IllegalStateException, IOException {
		String upFolderUrl = context.getRealPath("/fileuser" + "/" + username);
		File upFolder = new File(upFolderUrl);
		if (!upFolder.exists()) {
			upFolder.mkdirs();
		}

		String newFileUrl = upFolderUrl + "/" + file.getOriginalFilename();
		File newFile = new File(newFileUrl);
		file.transferTo(newFile);
	}
}
