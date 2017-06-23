package com.choa.ex6;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;
import com.choa.util.SeDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	//SmartEditor
	@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
		
		FileService fileService = new FileService();
		return fileService.seUpload(seDTO, session);
		
		/*//callback
		String callback = seDTO.getCallback();
		
		//callback_func
		String cllback_func = seDTO.getCallback_func();
		
		//OriName
		String original_name = seDTO.getFiledata().getOriginalFilename();
		
		//defaultPath
		String defalultPath = session.getServletContext().getRealPath("resources/upload");
		
		File f = new File(defalultPath);
		
		//디렉터리가 존재 하지 않을 경우 디렉터리를 생성.
		if(!f.exists()){
			f.mkdirs();
		}
		
		//디렉터리에 저장할 파일명
		String realName = UUID.randomUUID().toString()+"_"+original_name;
		
		//디렉터리에 저장
		seDTO.getFiledata().transferTo(new File(f, realName));
		
		//
		String file_result = "&bNewLine=true&sFileName="+original_name+"&sFileURL=/ex6/resources/upload/"+realName;
		
		return "redirect:"+callback+"?callback_func="+cllback_func+file_result;*/
	}
	
	//파일 다운
	@RequestMapping(value="fileDown",method=RequestMethod.GET)
	public ModelAndView fileDown(String fileName, HttpSession session, String oriName){
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, fileName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download");
		mv.addObject("oriName", oriName);
		mv.addObject("downLoadFile", f);
		
		return mv;
	}
	
	
	//파일 삭제
	@RequestMapping(value="fileDelete",method=RequestMethod.GET)
	public void fileDelete(String fileName, HttpSession session)throws Exception{
		FileService f = new FileService();
		f.fileDelete(fileName, session);
		
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){		
	}
	//�떎以� �뙆�씪 �뾽濡쒕뱶 -�뙆�씪誘명꽣 �씠由꾩쓣 紐⑤Ⅴ嫄곕굹 媛��닔媛� �쑀�룞�쟻�씪�븣
	@RequestMapping(value="upload", method=RequestMethod.POST)	
	public void upload(MultipartHttpServletRequest request){
		
		Iterator<String> it=request.getFileNames();
		ArrayList<MultipartFile> muti = new ArrayList<MultipartFile>();
		while (it.hasNext()){
			MultipartFile m = request.getFile(it.next());
			muti.add(m);			
		}
		for(MultipartFile m : muti){
			System.out.println(m.getOriginalFilename());
		}
		
	}
	
	
	//�떎以� �뙆�씪 �뾽濡쒕뱶 -�뙆�씪誘명꽣 �씠由꾩씠 媛숈쓣�븣 
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)	
	public void sameMultiFileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar =request.getFiles("f1");
		for(MultipartFile f: ar){
			System.out.println(f.getOriginalFilename());
		}
		
	}
	
	
	public void sameMultiFileUpload(SameMultiFileDTO sameMultiFileDTO){
		for(int i=0; i<sameMultiFileDTO.getF1().length; i++){
		 System.out.println(sameMultiFileDTO.getF1()[i].getOriginalFilename());
		}
		
	}
	
	public void sameMultiFileUpload(MultipartFile [] f1){
		for(int i=0; i<f1.length; i++){
		 System.out.println(f1[i].getOriginalFilename());
		}
		
	}
	
	//�떎以� �뙆�씪 �뾽濡쒕뱶 -�뙆�씪誘명꽣 �씠由꾩씠 �떎瑜쇰븣
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartHttpServletRequest request){		
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}	
	public void multiFileUpload(MultiFileDTO multiFileDTO){		
		System.out.println(multiFileDTO.getF1().getOriginalFilename());
		System.out.println(multiFileDTO.getF2().getOriginalFilename());		
	}
	public void multiFileUpload(MultipartFile f1, MultipartFile f2){		
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());		
	}
	
	//�떒�씪 �뙆�씪 �뾽濡쒕뱶
	
	public void fileUpload(MultipartHttpServletRequest request){	}	
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session)throws Exception{	
		
		FileService fileService = new FileService();
		String fileName=fileService.fileSave(f1, session);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("file/fileView");
		mv.addObject("fileName", fileName);
		mv.addObject("oname", f1.getOriginalFilename());
		return mv;
		
	}
	
	public void fileUpload(FileDTO fileDTO){	}

}
