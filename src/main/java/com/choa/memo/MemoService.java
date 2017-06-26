package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	
	@Inject
	private MemoDAO memoDAO;
	
	public List<MemoDTO> memoList(ListInfo listInfo) throws Exception{
		int count = memoDAO.memoCount(listInfo);
		listInfo.makePage(count);
		listInfo.setRow();
		
		return memoDAO.memoList(listInfo);
	}
	
	public MemoDTO memoView(int num) throws Exception{
		
		return memoDAO.memoView(num);
	}
	
	public int memoInsert(MemoDTO memoDTO) throws Exception{
		
		return memoDAO.memoInsert(memoDTO);
	}
	
	public int memoUpdate(MemoDTO memoDTO) throws Exception{
		
		return memoDAO.memoUpdate(memoDTO);
	}
	
	public int memoDelete(int num) throws Exception{
		
		return memoDAO.memoDelete(num);
	}

}
