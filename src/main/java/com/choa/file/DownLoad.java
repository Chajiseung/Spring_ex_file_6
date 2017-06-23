package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownLoad extends AbstractView{ // Class 가 View의 역할을 하기 위해서 상속 받음.
	
	public DownLoad() {
		setContentType("appalication/download;charset=UTF-8"); 
	}
	
	//파일 다운로드를 처리하는 View
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		File f = (File)model.get("downloadFile");
		String oriName = (String)model.get("oriName");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		
		//String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		
		String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		fileName = fileName.substring(fileName.lastIndexOf("_")+1);
		
		response.setHeader("content-Disposition", "attachment;fileName=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fi = null;
		
		fi = new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
	}
}
