package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
/*	@Select("SELECT no,subject,name,TO_CHAR(regdate, 'YYYY-MM-DD'),hit,num "
			+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM (SELECT /*+ INDEX_DESC(spring_board_sb_no_pk)no,subject,name,regdate,hit "
			+"FROM spring_board)) "
			+"WHERE num BETWEEN #{start} AND #{end}") */
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	// 시퀀스
/*	@SelectKey(keyProperty = "no", resultType = int.class, before = true,
			statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_board")
	@Insert("INSERT INTO spring_board VALUES("
			+"#{no},#{name},#{subject},#{content},#{pwd},SYSDATE,0)") */
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
}
