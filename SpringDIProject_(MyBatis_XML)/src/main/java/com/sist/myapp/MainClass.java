package com.sist.myapp;
import java.util.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.model.Model;
public class MainClass {
	private Model model;
	
	public void setModel(Model model) {
		this.model = model;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	MainClass mc=new MainClass(); // fdao,rdao,gdao => null -> 주소값이 있는 dao를 사용 => 스프링에서 생성된 객체만 dao에 주소가 있다
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		System.out.println("===== menu =====");
		System.out.println("1. 레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("========================");
		Scanner scan=new Scanner(System.in);
		System.out.println("메뉴를 선택하세요 : ");
		int no=scan.nextInt();
		if(no==1)
		{
			mc.model.recipeListData();
		}
		if(no==2)
		{
			mc.model.foodListData();
		}
		else if(no==3)
		{
			mc.model.goodsListData();
		}
		
	}

}
