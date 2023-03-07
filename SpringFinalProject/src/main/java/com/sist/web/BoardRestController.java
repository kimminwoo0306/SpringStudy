package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import com.sist.dao.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/list_vue.do",produces = "text/plain;charset=utf-8")
	public String board_list(int page)
	{
		Map map=new HashMap();
		map.put("start", (page*10)-9);
		map.put("end", page*10);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		
		// JSON변환
		JSONArray arr=new JSONArray();
		int i=0;
		for(BoardVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("subject", vo.getSubject());
			obj.put("name", vo.getName());
			obj.put("dbday", vo.getDbday());
			obj.put("hit", vo.getHit());
			if(i==0)
			{
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
}
