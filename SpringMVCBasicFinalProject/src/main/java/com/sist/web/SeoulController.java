package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.SeoulDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	
	@GetMapping("seoul/list.do")
	public String seoul_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		List<SeoulLocationVO> list=dao.seoulLocationListData(map);
		int totalpage=dao.seoulTotalPage();
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "seoul/list";
	}
	
	@GetMapping("seoul/detail.do")
	public String seoul_detail(int no,Model model)
	{
		SeoulLocationVO vo=dao.seoulDetailData(no);
		String address=vo.getAddress();
		String[] addr=address.split(" ");
		Map map=new HashMap();
		map.put("address", addr[2].trim());
		List<FoodVO> list=dao.seoulFoodData(map);
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		return "seoul/detail";
	}
	
	@RequestMapping("seoul/find.do")
	public String seoul_find(String address, String page, Model model)
	{
		String ss="";
		if(address==null || address.equals(""))
		{
			ss="all";
		}
		else
		{
			ss=address;
		}
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("ss", ss);
		List<SeoulLocationVO> list=dao.seoulFindData(map);
		model.addAttribute("list", list);
		return "seoul/find";
	}
	
}
