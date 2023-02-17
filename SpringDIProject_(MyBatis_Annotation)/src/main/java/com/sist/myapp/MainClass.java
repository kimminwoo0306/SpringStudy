package com.sist.myapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.model.Model;
@Component
// id=사용자 정의, 자동지정 (클래스명 => 첫자만 소문자)
public class MainClass {
	@Autowired
	private Model model; // new Model()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
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
