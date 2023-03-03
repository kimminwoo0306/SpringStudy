package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import com.sist.dao.*;

@RestController
public class JejuRestController {
	@Autowired
	private JejuDAO dao;
	
	@GetMapping(value="jeju/jeju_list_vue.do",produces="text/plain;charset=utf-8")
	public String jeju_food_list_vue(Map map)
	{
		List<JejuFoodVO> list=dao.jejuFoodVueListData(map);
		JSONArray arr=new JSONArray();
		int i=0;
		for(JejuFoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("title", vo.getTitle());
			obj.put("poster",vo.getPoster());
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	/*
	 * NO         NUMBER         
	TITLE      VARCHAR2(200)  
	URL        VARCHAR2(1000) 
	POSTER     VARCHAR2(1000) 
	IMAGE      CLOB           
	ADDR       VARCHAR2(500)  
	ADDR2      VARCHAR2(500)  
	TEL        VARCHAR2(100)  
	TYPE       VARCHAR2(100)  
	PARKING    VARCHAR2(100)  
	TIME       VARCHAR2(500)  
	MENU       VARCHAR2(2000) 
	SCORE      VARCHAR2(50)   
	HIT        NUMBER
	 */
	@GetMapping(value="jeju/jeju_detail_vue.do",produces="text/plain;charset=utf-8")
	public String jeju_detail_vue(int no)
	{
		JejuFoodVO vo=dao.jejuDetailData(no);
		JSONObject obj=new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("poster", vo.getPoster());
		obj.put("addr", vo.getAddr());
		obj.put("tel", vo.getTel());
		obj.put("type", vo.getType());
		obj.put("parking", vo.getParking());
		obj.put("time", vo.getTime());
		obj.put("menu", vo.getMenu());
		obj.put("score", vo.getScore());
		obj.put("hit", vo.getHit());
		return obj.toJSONString();
	}
}
