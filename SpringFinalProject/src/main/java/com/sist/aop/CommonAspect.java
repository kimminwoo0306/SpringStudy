package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// 공통모듈 => 공통으로 적용되는 기능을 모아서 관리 => 트랜잭션, 보안 (제작되어 있다)
/*
 *  트랜잭션 : @Transactional
 *      conn.setAutoCommit(false)
 *        SQL
 *        SQL
 *        ...
 *        conn.commit()
 *        
 *        => conn.rollback()
 *        보안 : 인증 / 인가
 *        => 사용자 정의 : 로그파일
 */
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.FoodDAO;
import com.sist.openapi.*;
@Aspect
@Component
public class CommonAspect {
	@Autowired
	private FoodDAO dao;
/*	@Autowired
	private NaverNewsManager mgr;
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("=======================================");
		System.out.println("클라이언트 요청전:"+jp.getSignature().getName());
		obj=jp.proceed(); // 메소드 호출
		System.out.println("클라이언트 요청 처리 종료:");
		long end=System.currentTimeMillis();
		System.out.println("요청 처리에 걸린 시간:"+(end-start));
		return obj;
	}
	@After("execution(* com.sist.web.*FController.*(..))")
	public void foodData()
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<FoodVO> tList=dao.foodTop7();
		for(FoodVO vo:tList)
		{
			String address=vo.getAddress();
			String[] addr=address.split(" ");
			vo.setAddress(addr[1].trim());
		}
		request.setAttribute("tList", tList);
		
		List<NewsVO> nList=mgr.newsListData("맛집");
		request.setAttribute("nList", nList);
	}*/
}



