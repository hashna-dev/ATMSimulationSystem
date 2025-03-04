package com.ty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.helper.FileUploadHelper;

@RestController
public class FileController {
	
	@Autowired
	   FileUploadHelper helper;
	 
 
     @PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    	 
    	 System.out.println(file.getContentType());
    	 System.out.println(file.getOriginalFilename());
    	 System.out.println(file.getSize());
    	 System.out.println(file.getName());
    	 
    	 
    	 if (file.isEmpty()) {
    		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				 					.body("REQUEST MUST CONTAIN A FILE");
    		 
		}
    	 if(!file.getContentType().equals("image/jpeg")) {
    		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				 					.body("NOT SUPPORTED ....only jpeg content is supported");
    	    	
    	 }
    	 
    	 try {
    	 boolean result=helper.uploadFile(file);
    	 
    	 if(result) {
    		 return ResponseEntity.ok("FILE UPLOADED SUCCESSFULLY.....!");
    	 } }catch (Exception e) {
			e.printStackTrace();
		}
		
    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING WENT wRONG ...!TRY AGAIN");
	    	
     			
	}
}