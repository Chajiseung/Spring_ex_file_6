package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;

public class DTOTest extends MyAbstractTest{
	
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	

	@Test
	public void test() throws Exception{
		BoardDTO boardDTO = noticeDAOImpl.boardView(501);
		assertNotNull(boardDTO);
	}

}
