package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// �޸� �Ҵ� <bean id="dao">

import com.sist.mapper.SeoulMapper;
@Repository("dao")
public class SeoulDAO {
	@Autowired // �ڵ� ����
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData()
	{
		return mapper.seoulListData();
	}
}
