package com.sist.myapp;
import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.service.EmpDeptService;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;
@Component("mc")
public class MainClass {
	
	@Autowired
	private EmpDAO edao;
	
	@Autowired
	private DeptDAO ddao;
	
	@Autowired
	private EmpDeptService es;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
			//	new ClassPathXmlApplicationContext(new String[] {"application-context.xml","application-datasource.xml"});
		MainClass mc=app.getBean("mc",MainClass.class);
		List<EmpVO> eList=mc.edao.empListData();
		List<DeptVO> dList=mc.ddao.deptListData();
		System.out.println("======== 사원 목록 ========");
		for(EmpVO vo:eList)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
		System.out.println("========== 부서 목록 ==========");
		for(DeptVO vo:dList)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
		
		System.out.println("=========== Service이용 =============");
		List<EmpVO> list=mc.es.empListData();
		List<DeptVO> list2=mc.es.deptListData();
		System.out.println("======== 사원 목록 ========");
		for(EmpVO vo:eList)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
		System.out.println("========== 부서 목록 ==========");
		for(DeptVO vo:dList)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
	}

}
