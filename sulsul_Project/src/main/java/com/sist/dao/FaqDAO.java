package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;

import lombok.Getter;
import lombok.Setter;

import com.sist.mapper.*;

@Repository
public class FaqDAO {
	@Autowired
	private FaqMapper mapper;
	
	// 나라별 센터 소개
	public List<NationIntroduceVO> nationListData()
	{
		return mapper.nationListData();
	}
	
	// faq 카테고리별
	public List<FaqVO> faqList1(Map map)
	{
		return mapper.faqList1(map);
	}
		
	// faq 총 페이지
	public int faqTotalPage1()
	{
		return mapper.faqTotalPage1();
	}
	
	// 카테고리별 메소드 (2번)
	public List<FaqVO> faqList2(Map map)
	{
		return mapper.faqList2(map);
	}
		
	// faq 총 페이지
	public int faqTotalPage2()
	{
		return mapper.faqTotalPage2();
	}
	
	// 카테고리별 메소드 (3번)
	public List<FaqVO> faqList3(Map map)
	{
		return mapper.faqList3(map);
	}
			
	// faq 총 페이지
	public int faqTotalPage3()
	{
		return mapper.faqTotalPage3();
	}
	
	// 카테고리별 메소드 (4번)
	public List<FaqVO> faqList4(Map map)
	{
		return mapper.faqList4(map);
	}
				
	// faq 총 페이지
	public int faqTotalPage4()
	{
		return mapper.faqTotalPage4();
	}
	
	// 카테고리별 메소드 (5번)
	public List<FaqVO> faqList5(Map map)
	{
		return mapper.faqList5(map);
	}
				
	// faq 총 페이지
	public int faqTotalPage5()
	{
		return mapper.faqTotalPage5();
	}
	
	// 카테고리별 메소드 (6번)
	public List<FaqVO> faqList6(Map map)
	{
		return mapper.faqList6(map);
	}
				
	// faq 총 페이지
	public int faqTotalPage6()
	{
		return mapper.faqTotalPage6();
	}
	
	// 카테고리별 메소드 (7번)
	public List<FaqVO> faqList7(Map map)
	{
		return mapper.faqList7(map);
	}
				
	// faq 총 페이지
	public int faqTotalPage7()
	{
		return mapper.faqTotalPage7();
	}
		
	// 카테고리별 메소드 (9번)
	public List<FaqVO> faqList8(Map map)
	{
		return mapper.faqList8(map);
	}
						
	// faq 총 페이지
	public int faqTotalPage8()
	{
		return mapper.faqTotalPage8();
	}
	
	// faq 상세페이지
	public FaqVO faq_Detail(int fno)
	{
		return mapper.faq_Detail(fno);
	}
	// faq검색한 경우 전체
	public List<FaqVO> faqSearchFindData1()
	{
		return mapper.faqSearchFindData1();
	}
		
	// faq 카운트값
	public int faqFindCount1()
	{
		return mapper.faqFindCount1();
	}
	// faq검색 
	public List<FaqVO> faqSearchFindData2(String subject)
	{
		return mapper.faqSearchFindData2(subject);
	}
		
	// faq 총페이지
	// faq 카운트값
	public int askFindCount2(String subject)
	{
		return mapper.faqFindCount2(subject);
	}
	
}
