package com.sist.mapper;
/*
 * 	private String title,addr,price;
 */
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;

public interface LocationMapper {
	@Select("SELECT title,addr,price FROM JejuLocation")
	public List<JejuLocationVO> locationListData();
}
