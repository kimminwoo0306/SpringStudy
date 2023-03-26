package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class AskDAO {
	@Autowired
	private AskMapper mapper;
	// 목록 출력 (로그인안했을경우)

	public List<AskVO> asknotListData()
	{
		return mapper.asknotListData();
	}
	// 목록 출력

	public List<AskVO> askListData(String id)
	{
		return mapper.askListData(id);
	}
		
	// 문의 하기

    public void askInsert(AskVO vo)
    {
    	 mapper.askInsert(vo);
    }
    
    //목록 리스트 카운트(로그인 안했을 경우)
  	public int asknotTotalData()
  	{
  		return mapper.asknotTotalData();
  	}
    // 문의 내역 카운트
    public int askTotalData(String id)
    {
    	return mapper.askTotalData(id);
    }
    
    // 상세 페이지
 	public AskVO askDetailData(int ano)
 	{
 		return mapper.askDetailData(ano);
 	}
 	// 비밀번호
  	// 수정하기 
 	public String askUpdate(AskVO vo)
 	{
 		String res="no";
 		String db_pwd=mapper.askGetPassword(vo.getAno());
 		if(db_pwd.equals(vo.getPwd()))
 		{
 			mapper.askUpdate(vo);
 			res="yes";
 		}
 		return res;
 	}
 	
 	// 삭제하기
 	public String askDelete(int ano,String pwd)
 	{
 		String res="no";
 		String db_pwd=mapper.askGetPassword(ano);
 		
 		if(db_pwd.equals(pwd))
 		{
 			mapper.askDelete(ano);
 			res="yes";
 		}
 		System.out.println("dao res"+res);
 		return res;
 	}
}