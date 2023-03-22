package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller
@RequestMapping("camp/")
public class CampController {
   @Autowired
   private CampDAO dao;
   
   @GetMapping("camp_list")
   public String camp_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=50;
	   int start=(curpage*rowSize)-rowSize;
	   List<CampEntity> list=dao.campListData(start);
	   int totalpage=dao.campTotalPage();
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   List<CampEntity> cList=new ArrayList<CampEntity>();
		  int i=0;
		  for(CampEntity vo:list)
		  {
			  String image=vo.getImage();
			  if(!image.contains("noimg"))
			  {
				  if(i>20)
					  break;
				  cList.add(vo);
				  i++;
			  }
		  }
		  
	   model.addAttribute("cList", cList);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("main_html", "camp/camp_list");
	   return "main";
   }
   @GetMapping("camp_detail")
   public String camp_detail(int cno,Model model)
   {
	   CampEntity vo=dao.findByCno(cno);

	   model.addAttribute("vo", vo);
	   model.addAttribute("main_html", "camp/camp_detail");
	   return "main";
   }
   @RequestMapping("camp_find")
   public String camp_find(String address,String page,Model model)
   {
	   if(address==null)
		   address="충주";
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(curpage*rowSize)-rowSize;
	   List<CampEntity> list=dao.campFindData(address, start);
	   int totalpage=dao.campFindTotalPage(address);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
	   model.addAttribute("address", address);
	   model.addAttribute("main_html", "camp/camp_find");
	   return "main";
   }

}