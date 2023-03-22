package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.CampEntity;
import com.sist.web.entity.CategoryDataMapping;

@Controller
public class MainController {
  @Autowired
  private CampDAO dao;
  
  @GetMapping("/")
  public String main_page(Model model)
  {  
	  List<CampEntity> list=dao.campTop20();
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
	  model.addAttribute("main_html", "main/home");
	  return "main";
  }
}