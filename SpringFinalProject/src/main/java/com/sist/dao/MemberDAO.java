package com.sist.dao;
import com.sist.mapper.*;
import com.sist.vo.*;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
/*	@Select("SELECT COUNT(*) FROM chat_member "
			+"WHERE id=#{id }")
	public int memberIdCheck(String id); */
	
//	@Select("SELECT id,pwd,name from chat_member "
//			+"WHERE id=#{id}")
	public MemberVO memberLogin(String id, String pwd)
	{
		MemberVO vo=new MemberVO();
		// ID체크
		int count=mapper.memberIdCheck(id);
		if(count==0) // ID가 없는 상태
		{
			vo.setMsg("NOID");
		}
		else
		{
			MemberVO dbvo=mapper.memberLogin(id);
			if(dbvo.getPwd().equals(pwd))
			{
				vo.setMsg("OK");
				vo.setId(dbvo.getId());
				vo.setName(dbvo.getName());
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
}
