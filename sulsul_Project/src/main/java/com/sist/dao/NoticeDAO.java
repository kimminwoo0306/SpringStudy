package com.sist.dao;

import java.util.Map;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.NoticeMapper;

@Repository
public class NoticeDAO {
 @Autowired
 private NoticeMapper mapper;
 
	 public List<NoticeVO> noticeListData(Map map)
	 {
		 return mapper.noticeListData(map);
	 }
	 
	 public int noticeTotalPage()
	 {
		 return mapper.noticeTotalPage();
	 }
	 
	   public void noticeInsert(NoticeVO vo)
	   {
		   mapper.noticeInsert(vo);
	   }
	   
	   public NoticeVO noticeDetailData(int no)
	   {
		   mapper.noticeHitIncrement(no);
		   return mapper.noticeDetailData(no);
	   }
		   public String noticeUpdate(NoticeVO vo)
		   {
				String res="";
				String db_pwd=mapper.noticeGetPassword(vo.getNo());
				if(db_pwd.equals(vo.getPwd()))
				{
					mapper.noticeUpdate(vo);
					res="yes";
				}
			     return res;
		   }
		   
		   public String noticeDelete(int no,String pwd)
		   { 
			   String res="no";
		      String db_pwd=mapper.noticeGetPassword(no);
		      if(db_pwd.equals(pwd))
		      {
		         mapper.noticeDelete(no);
		         res="yes";
		      
		     }
		       return res;
		   }
}
