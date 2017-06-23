package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	//delete
	public Boolean fileDelete(String fileName, HttpSession session)throws Exception{
		
		String realpath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realpath, fileName);
		System.out.println(realpath);
		boolean result = f.delete();
		return result;
	}
	
	//save
	public String fileSave(MultipartFile m,HttpSession session)throws Exception{
		FileSaver fileSaver = new FileSaver();
		String fileName = fileSaver.filesave(session.getServletContext().getRealPath("resources/upload"), m);
		
		return fileName;
	}

}
