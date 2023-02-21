package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO {
	@Autowired // mapper를 구현한 클래스의 객체 주소값을 스프링으로부터 받아 온다
	private BoardMapper mapper;
	/*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, hit, num "
			+"FROM SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM SELECT /*+ INDEX_DESC(spring_board sb_no_pk)no,subject,name,regdate,hit "
			+"FROM spring_board)) "
			+"WHERE num BETWEEN #{start} AND #{end}") */
	// #{start=>key} => map.get("start"), map.get("end")
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	/*@Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
			   +"VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
		// #{name} => vo.getName()*/
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	/*
	 * @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
		public int boardTotalPage();
	 */
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	/*
	 * @Update("UPDATE spring_board SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
	   public void hitIncrement(int no);
	   
	   @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, hit "
			  +"FROM spring_board "
			  +"WHERE no=#{no}")
	   public BoardVO boardDetailData(int no);
	 */
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	/*
	 * @Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	   public String boardGetPwd(int no);
	   // 데이터 수정
	   @Update("UPDATE spring_board SET "
			  +"name=#{name}, subject=#{subject}, content=#{content} "
			  +"WHERE no=#{no}")
	   public void boardUpdateData(BoardVO vo);
	 */
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPwd(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	
	/*
	 *	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
   		public String boardGetPwd(int no); 
   		@Delete("DELETE FROM spring_board WHERE no=#{no}")
   		public void boardDelete(int no);
	 */
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck=false;
		// 비밀번호 읽기
		String db_pwd=mapper.boardGetPwd(no);
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			mapper.boardDelete(no);
		}
		return bCheck;
	}
	
	/*
	 * @Select("SELECT COUNT(*) FROM spring_board "
		  	  +"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	   public int boardFindCount(Map map); */
	 public int boardFindCount(Map map)
	 {
		 return mapper.boardFindCount(map);
	 }
	/*   @Select("SELECT no,name,subject,TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit FROM spring_board "
			  +"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	   public List<BoardVO> boardFindData(Map map);
	 */
	 public List<BoardVO> boardFindData(Map map)
	 {
		 return mapper.boardFindData(map);
	 }
}








