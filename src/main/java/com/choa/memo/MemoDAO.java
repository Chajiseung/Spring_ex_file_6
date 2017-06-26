package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	
	@Inject
	private SqlSession sqlSession;
	private String NAMESPACE="MemoMapper.";
	
	public int memoCount(ListInfo listInfo) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memoCount", listInfo);
	}
	
	//LIST
	public List<MemoDTO> memoList(ListInfo listInfo) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memoList", listInfo);
	}
	//INSERT
	public int memoInsert(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memoInsert", memoDTO);
	}
	//VIEW
	public MemoDTO memoView(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memoView", num);
	}
	
	//UPDATE
	public int memoUpdate(MemoDTO memoDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"memoUpdate", memoDTO);
	}
	//DELETE
	public int memoDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"memoDelete", num);
	}
}
