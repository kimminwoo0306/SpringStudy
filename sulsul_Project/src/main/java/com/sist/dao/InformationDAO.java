package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class InformationDAO {
	@Autowired
	private InformationMapper mapper;
	
	public List<InformationUseVO> informationListData(Map map)
	{
		return mapper.informationListData(map);/////
	}
	
	public int informationTotalPage()
	{
		return mapper.informationTotalPage();
	}
	
	// 이용안내 게시물 클릭시 조회수 증가
	// 이용안내 상세페이지
	public InformationUseVO informationDetailData(int iuno)
	{
		mapper.informationHitIncrement(iuno);
		return mapper.informationDetailData(iuno);
	}
}




















