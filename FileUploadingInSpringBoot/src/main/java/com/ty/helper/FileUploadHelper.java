package com.ty.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	
	public final String 
	uploadDir="C:\\Users\\hashn\\OneDrive\\Desktop\\SpringBoot\\FileUploadingInSpringBoot\\src\\main\\resources\\image";

	public boolean uploadFile(MultipartFile file) {
		boolean f=false;
		
		try {
		InputStream is= file.getInputStream();
		byte [] data= new byte[is.available()];
		is.read();
		FileOutputStream fos=new FileOutputStream(uploadDir + File.separator + file.getOriginalFilename());
	   fos.write(data);
	   fos.flush();
	   fos.close();
	   f=true;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


}