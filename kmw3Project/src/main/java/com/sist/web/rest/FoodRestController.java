package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@RequestMapping("food/")
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
	@Autowired
	private CategoryDAO cdao;
	@Autowired
	private CampDAO dao;

}
