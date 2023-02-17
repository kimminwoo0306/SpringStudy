package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.mapper.LocationMapper;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
// BI
@Service
public class JejuService {
	@Autowired
	private FoodMapper fmapper;
	@Autowired
	private LocationMapper lmapper;
	
//	@Select("SELECT no,title,addr,score,rownum FROM JejuFood WHERE rownum <=30")
	public List<JejuFoodVO> foodListData()
	{
		return fmapper.foodListData();
	}
	
//	@Select("SELECT title,addr,price FROM JejuLocation")
	public List<JejuLocationVO> locationListData()
	{
		return lmapper.locationListData();
	}
}
