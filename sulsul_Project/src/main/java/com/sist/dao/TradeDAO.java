package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.TradeMapper;
import com.sist.vo.TradeVO;

@Repository
public class TradeDAO {
	@Autowired
	private TradeMapper mapper;
	public List<TradeVO> tradeListData(Map map) {
		return mapper.tradeListData(map);
	}
	public int tradeListTotalPage() {
		return mapper.tradeListTotalPage();
	}
	
	// 중고거래 조회수
	
	// 중고거래 상세페이지
	public TradeVO tradeDetailData(int tdno) {
		mapper.tradeHitIncrement(tdno);
		return mapper.tradeDetailData(tdno);
	}
}
