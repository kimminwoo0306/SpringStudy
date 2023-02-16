package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.CategoryMapper;
import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

// DAO�������� ���� (BI)
@Service
public class FoodService {
	@Autowired
	private FoodMapper fMapper;
	
	@Autowired
	private CategoryMapper gMapper;
	
	public List<CategoryVO> categoryListData()
	{
		return gMapper.categoryListData();
	}
	public List<FoodVO> foodlistData(int cno)
	{
		return fMapper.foodlistData(cno);
	}
}
