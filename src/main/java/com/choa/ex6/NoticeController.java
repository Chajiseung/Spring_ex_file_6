package com.choa.ex6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject  //type으로 찾음
	private NoticeServiceImpl noticeService;
	

	
	
	@RequestMapping(value="noticeList",method=RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo) throws Exception{
				
	
		
		System.out.println(listInfo.getCurPage());
		List<BoardDTO> ar = noticeService.boardList(listInfo);
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		model.addAttribute("listInfo", listInfo);
		;
		return "/board/boardList";
		
	}
	@RequestMapping(value="noticeView",method=RequestMethod.GET)
	public String noticeView(Integer num,Model model) throws Exception{
		if(num==null){}		
		NoticeDTO noticeDTO =(NoticeDTO) noticeService.boardView(num);		
		model.addAttribute("dto", noticeDTO);
		model.addAttribute("board", "notice");
		return "board/boardView";
		
	}
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String noticeWrite(Integer num, Model model) throws Exception{
		model.addAttribute("path", "Write");
		model.addAttribute("board", "notice");
		return "board/boardWrite";
		
		
	}
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO,RedirectAttributes rd) throws Exception{
		
			int result = noticeService.boardWrite(noticeDTO);
			String message = "FAIL";
			if(result>0){
				message="SUCCESS";
			}
			rd.addFlashAttribute("message", message);
			
		return "redirect:noticeList?curPage=1";
		
		
	}
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String noticeUpdate(Model model, Integer num )throws Exception{
		
		NoticeDTO noticeDTO =(NoticeDTO) noticeService.boardView(num);
		model.addAttribute("path", "Update");
		model.addAttribute("board", "notice");
		model.addAttribute("dto", noticeDTO);
		
		return"board/boardWrite";
	}
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		
			int result = noticeService.boardUpdate(noticeDTO);
			String message = "FAIL";
			if(result>0){
				message = "SUCCESS";
			}
			rd.addFlashAttribute("message", message);
			
	
		
		return "redirect:noticeList";
	}
	@RequestMapping(value="noticeDelete",method=RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes rd)throws Exception{
		
			int result = noticeService.boardDelete(num);
			String message = "FAIL";
			if(result>0){				
				message="SUCCESS";
			}
			rd.addFlashAttribute("message", message);
	
		return "redirect:noticeList?curPage=1";
	}

}
