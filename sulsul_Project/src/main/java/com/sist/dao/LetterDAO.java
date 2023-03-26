package com.sist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.LetterMapper;
import com.sist.vo.FreeBoardVO;
import com.sist.vo.LetterVO;

@Repository
public class LetterDAO {
	@Autowired
	private LetterMapper mapper;
	
	// 받은쪽지 갯수
	@Select("SELECT COUNT(*) FROM sul_letter_2_2 WHERE recv_id = #{id}")
	public int recv_letter_count(String id) {
		return mapper.recv_letter_count(id);
	}
	
	// 받은쪽지 리스트
	public List<LetterVO> recv_letterList(Map map) {
		return mapper.recv_letterList(map);
	}
	
	// 받은쪽지 총 페이지
	public int recv_letterTotalPage(String id) {
		return mapper.recv_letterTotalPage(id);
	}
	
	// 보낸쪽지 리스트
	public List<LetterVO> send_letterList(Map map) {
		return mapper.send_letterList(map);
	}
	
	// 보낸쪽지 총 페이지
	public int send_letterTotalPage(String id) {
		return mapper.send_letterTotalPage(id);
	}
	
	// 쪽지 보내기
	public void letterInsert(LetterVO vo) {
		mapper.letterInsert(vo);
	}
	
	// 쪽지 읽음
	public void letter_read_chk(Map map) {
		mapper.letter_read_chk(map);
	}
	
	// 쪽지 상세페이지
	public LetterVO letter_Detail(int lno) {
		
		return mapper.letter_Detail(lno);
	}
	
	// 받은쪽지 아이디확인
	public String send_getid_letter(int lno) {
		return mapper.recv_getid_letter(lno);
	}
	
	// 보낸쪽지 아이디확인
	public String recv_getid_letter(int lno) {
		return mapper.send_getid_letter(lno);
	}
	
	// 쪽지 삭제
	public void recv_letter_Delete(Map map) {
		mapper.recv_letter_Delete(map);
	}
	
}
