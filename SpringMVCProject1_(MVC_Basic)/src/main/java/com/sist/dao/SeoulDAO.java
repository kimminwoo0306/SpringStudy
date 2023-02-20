package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
/*
 *   Application:main() => System.out.println()
 *   Web -> Model => 브라우저 전송 => 브라우저 출력
 *   ------------------------------------------ DI/AOP는 동일
 *   DispatcherServlet에서 처리 => getBean()을 사용하지 않는다
 *   --------------------------------------------------- 스프링에 저장된 객체를 받는 경우에는 @Autowired
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;

	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	public int seoulTotalPage()
	{
		return mapper.seoulTotalPage();
	}
}
