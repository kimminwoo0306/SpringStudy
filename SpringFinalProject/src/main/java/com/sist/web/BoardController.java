package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list()
	{
		return "board/list";
	}
	@GetMapping("board/insert.do")
	public String board_insert(BoardVO vo)
	{
		return "board/insert";
	}
	@GetMapping("board/detail.do")
	public String board_detail(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/detail";
	}
	@GetMapping("board/update.do")
	public String board_update(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/update";
	}
	@GetMapping("board/delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
}
