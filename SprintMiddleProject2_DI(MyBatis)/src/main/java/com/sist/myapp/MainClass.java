package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

import lombok.Setter;
public class MainClass {
	@Setter
	private SeoulDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table= {"","seoul_location","seoul_nature","seoul_shop"};
		Scanner scan=new Scanner(System.in);
		System.out.println("���̺� ����: ");
		int no=scan.nextInt();
		Map map=new HashMap();
		map.put("seoul_tbl", table[no]);
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		// �̱��� �޸� 1�� ���, ��� Ŭ�������� ������ ����, �ٸ� Ŭ������ ������� ���� (������ => �������� Ŭ����)
		// ���ռ��� ���� ���α׷� (���������� ���ϰ�, �о��� ��쿡..), ������ ����(����)
		// ��ü������ ��ü�� ���� ����
		List<SeoulVO> list=mc.dao.seoulListData(map);
		for(SeoulVO vo:list)
		{
			System.out.println("���: "+vo.getTitle());
			System.out.println("�ּ�: "+vo.getAddress());
			System.out.println("����: "+vo.getMsg());
			System.out.println("=====================================");
		}
		System.out.println("���ϰ� �� ��ȣ �Է�");
		int i=scan.nextInt();
		map.put("seoul_tbl", table[no]);
		map.put("no", i);
		SeoulVO vo=mc.dao.seoulDetailData(map);
		System.out.println("��ȣ:"+vo.getNo());
		System.out.println("����:"+vo.getTitle());
		System.out.println("�ּ�:"+vo.getAddress());
		System.out.println("����:"+vo.getMsg());
		
	}

}
