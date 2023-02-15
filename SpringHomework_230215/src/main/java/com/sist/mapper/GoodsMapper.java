package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface GoodsMapper {
	@Select("select no, goods_name, goods_price,rownum from "
			+ "(select no, goods_name, goods_price from  ${goods_tbl} "
			+ "order by no ASC) "
			+ "where rownum <= 30")
	public List<GoodsVO> goodsListData(Map map);
}
