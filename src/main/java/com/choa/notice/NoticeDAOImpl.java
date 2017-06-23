package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

@Repository
//NoticeDAO noticeDAO = new NoticeDAO();
public class NoticeDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";
	
	
	
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		
		
		return sqlSession.selectList(NAMESPACE+"list",listInfo);
		
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {	
		
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"view", num);			
		
		return boardDTO;	
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		
		int result = sqlSession.insert(NAMESPACE+"write", boardDTO);
		
		
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.update(NAMESPACE+"update", boardDTO);
		
		
		return result;
	}

	@Override
	public int boardDelete(int num) throws Exception {
		int result = sqlSession.delete(NAMESPACE+"delete", num);
		
		return result;
	}

	@Override
	public int boardCount(ListInfo listInfo) throws Exception {
		
		int result = sqlSession.selectOne(NAMESPACE+"count",listInfo);
		
		return result;
	}

	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	

	

	
	

	

}
