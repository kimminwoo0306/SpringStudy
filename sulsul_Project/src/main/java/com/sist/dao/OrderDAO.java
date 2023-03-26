package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.CartVO;
@Repository
public class OrderDAO {
@Autowired 
private OrderMapper mapper;
 
public List<CartVO> orderListData(Map map)
{
	return mapper.orderListData(map);
}

public int orderTotalPage(String id)
{
	return mapper.orderTotalPage(id);
}

public List<CartVO> adminorderListData(Map map)
{
	return mapper.adminorderListData(map);
}
public int adminOrderTotalPage()
{
	return mapper.adminOrderTotalPage();
}
public void orderOkUpdate(int bno)
{
	 mapper.orderOkUpdate(bno);
}
}
