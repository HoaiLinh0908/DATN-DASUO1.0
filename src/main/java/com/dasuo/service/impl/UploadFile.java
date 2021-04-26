package com.dasuo.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadFile {
	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File("C:\\Fsoft\\FlightTicketManagement2\\dasuoo\\src\\main\\resources\\static\\uploadFile/"+file.getOriginalFilename()));
	}

}
