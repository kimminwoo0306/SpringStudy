package com.sist.myapp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.vo.*;
import com.sist.config.GoodsConfig;
import com.sist.dao.*;
@Component
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(GoodsConfig.class);
		String[] table= {"","all","best","new","special"};
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 전체");
		System.out.println("2. 베스트");
		System.out.println("3. 신상");
		System.out.println("4. 특가");
		System.out.println("=================");
		Scanner scan=new Scanner(System.in);
		int menu=scan.nextInt();
		
		Map map=new HashMap();
		map.put("goods_tbl", "goods_"+table[menu]);
		
		MainClass mc=app.getBean("mainClass", MainClass.class);
		List<GoodsVO> list=mc.dao.goodsListData(map);
		for(GoodsVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+"("+vo.getGoods_price()+")");
		}
		
	}

}
