package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.EventBoardVO;
import com.sist.vo.FreeBoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	// 자유게시판 목록

	public List<FreeBoardVO> freeboardListData(Map map) {
		return mapper.freeboardListData(map);
	}
	
	// 자유게시판 총 페이지
	public int freeboardTotalPage() {
		return mapper.freeboardTotalPage();
	}
	  
	// 자유게시판 sequence + 글 쓰기
	public void freeboardInsert(FreeBoardVO vo) {
		mapper.freeboardInsert(vo);
	}
	
	// 자유게시판 조회수 증가

	public FreeBoardVO freeboardDetailData(int fbno) {
		mapper.freeboardHitIncrement(fbno);
		return mapper.freeboardDetailData(fbno);
	}
	  
	// 자유게시판 비밀번호 확인 (수정 / 삭제시 필요)

	  
	// 자유게시판 글 수정

	public String freeboardUpdate(FreeBoardVO vo) {
		String res = "no";
		String db_pwd = mapper.freeboardGetPassword(vo.getFbno());
		if(db_pwd.equals(vo.getPwd())) {
			mapper.freeboardUpdate(vo);
			res = "yes";
		}
		return res;
	}
	  
	// 자유게시판 글 삭제

	public String freeboardDelete(int fbno, String pwd) {
		String res = "no";
		String db_pwd = mapper.freeboardGetPassword(fbno);
		if(encoder.matches(pwd, db_pwd)) {
			mapper.freeboardDelete(fbno);
			res = "yes";
		}
		return res;
	}
	
	// 자유게시판 검색 데이터
	public List<FreeBoardVO> freeboardFindData(Map map) {
		return mapper.freeboardFindData(map);
	}
	
	// 자유게시판 검색 결과수
	public int findCount(Map map) {
		return mapper.findCount(map);
	}
	
	// 자유게시판 검색 결과 총 페이지
	public int findTotalPage() {
		return mapper.findTotalPage();
	}
	
	
	
	// 이벤트게시판 목록

	public List<EventBoardVO> eventboardListData(Map map) {
		return mapper.eventboardListData(map);
	}
	
	// 이벤트게시판 총 페이지

	public int eventboardTotalPage() {
		return mapper.eventboardTotalPage();
	}
	// 이벤트게시판 판매행사 목록

	public List<EventBoardVO> eventboard_sell_ListData(Map map) {
		return mapper.eventboard_sell_ListData(map);
	}
	// 이벤트게시판 총 페이지
	public int eventboard_sell_TotalPage() {
		return mapper.eventboard_sell_TotalPage();
	}
	
	
	// 이벤트게시판 디너 목록

	public List<EventBoardVO> eventboard_dinner_ListData(Map map) {
		return mapper.eventboard_dinner_ListData(map);
	}
	
	// 이벤트게시판 디너 총 페이지
	public int eventboard_dinner_TotalPage() {
		return mapper.eventboard_dinner_TotalPage();
	}
	
	// 이벤트게시판 판매행사 목록
	public List<EventBoardVO> eventboard_edu_ListData(Map map) {
		return mapper.eventboard_edu_ListData(map);
	}
	
	// 이벤트게시판 총 페이지
	public int eventboard_edu_TotalPage() {
		return mapper.eventboard_edu_TotalPage();
	}
	
	// 이벤트게시판 시음회 목록
	public List<EventBoardVO> eventboard_si_ListData(Map map) {
		return mapper.eventboard_si_ListData(map);
	}
	
	// 이벤트게시판 총 페이지
	public int eventboard_si_TotalPage() {
		return mapper.eventboard_si_TotalPage();
	}
	
	// 이벤트게시판 판매행사 목록
	public List<EventBoardVO> eventboard_other_ListData(Map map) {
		return mapper.eventboard_other_ListData(map);
	}
	
	// 이벤트게시판 총 페이지
	public int eventboard_other_TotalPage() {
		return mapper.eventboard_other_TotalPage();
	}
	
	
	
	
	// 이벤트게시판 조회수 증가
	// 이벤트게시판 상세페이지
	public EventBoardVO eventboardDetailData(int ebno) {
		mapper.eventboardHitIncrement(ebno);;
		return mapper.eventboardDetailData(ebno);
	}
	
}


