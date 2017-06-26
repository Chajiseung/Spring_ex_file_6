package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;

public class TestCase extends MyAbstractTest{
	
	@Inject
	private MemoService memoService;

	@Test
	public void connectionTest()  throws Exception{
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setWriter("writer1");
		memoDTO.setContents("contentes1");
		
		int result = memoService.memoInsert(memoDTO);
		
		assertEquals(1, result);
	}

}
