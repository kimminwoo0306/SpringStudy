package com.sist.web;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.SeoulDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	
	@GetMapping("seoul/list.do")
	public String seoul_list(String page,Model model, HttpServletRequest request)
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
		
		//쿠키 관련
		List<SeoulLocationVO> sList=new ArrayList<SeoulLocationVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=cookies.length-1; i>=0; i--)
			{
				if(cookies[i].getName().startsWith("seoul"))
				{
					String no=cookies[i].getValue();
					SeoulLocationVO vo=dao.seoulDetailData(Integer.parseInt(no));
					sList.add(vo);
				}
			}
		}
		model.addAttribute("sList", sList);
		return "seoul/list";
	}
	@GetMapping("seoul/detail_before.do")
	public String seoul_detail_before(String no, HttpServletResponse response,RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("seoul"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60^72);
		// 브라우저 전송
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:detail.do";
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
