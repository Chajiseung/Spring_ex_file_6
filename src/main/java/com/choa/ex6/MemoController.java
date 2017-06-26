package com.choa.ex6;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

//@RestController @ResponseBody�� ��Ʈ�ѷ� �ż��� ���� ���� ������.
@Controller
@RequestMapping(value="/memo/**")

public class MemoController {
	
	@Inject
	private MemoService memoService;
	
	@RequestMapping(value="memoList")
	public void memoList(){}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody // view page�� �ƴ� DATA�� ����, return �ϴ� ���¸� JSON���� �ٲ���.
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage, 
								  @PathVariable("find") String find, @PathVariable("search") String search) throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		
		List<MemoDTO> list = memoService.memoList(listInfo);
		
		return list;
		
		
	}
	@RequestMapping(value="memoView/{num}") //@PathVariable("num") �ּҸ� �����ͷ� �޴°�.
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num) throws Exception{
		MemoDTO memoDTO = memoService.memoView(num);
		
		return memoDTO;
	}
	
	
	@RequestMapping(value="memoWrite", method = RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model) throws Exception{
		
		
		int result = memoService.memoInsert(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list = memoService.memoList(listInfo);
		model.addAttribute("list", list);
		/*String message = "Fail";
		if(result > 0){
			message = "Success";
		}
		model.addAttribute("message", message);
		model.addAttribute("result", result)*/;
		
		return list;
	}

}
