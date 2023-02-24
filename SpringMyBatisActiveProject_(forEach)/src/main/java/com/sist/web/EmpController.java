package com.sist.web;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// Model => 반드시 (@Controller, @RestController)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	// -> _ok.do => POST <form>, ajax
	@GetMapping("emp/list.do")
	public String emp_list(Model model)
	{
		List<String> list=dao.empNameListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	
	@PostMapping("emp/info.do")
	public String emp_info(Model model, String[] names)
	{
		Map map=new HashMap();
		map.put("names", names);
		List<EmpVO> list=dao.empInfoData(map);
		model.addAttribute("list", list);
		return "emp/info";
	}
}
