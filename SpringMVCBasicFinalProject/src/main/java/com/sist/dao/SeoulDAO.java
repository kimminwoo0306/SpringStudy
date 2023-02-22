package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
/*	@Select("SELECT no,title,poster,num "
			   +"FROM (SELECT no,title,poster,rownum as num "
			   +"FROM (SELECT no,title,poster "
			   +"FROM seoul_location ORDER BY no ASC)) "
			   +"WHERE num BETWEEN #{start} AND #{end}") */
		public List<SeoulLocationVO> seoulLocationListData(Map map)
		{
			return mapper.seoulLocationListData(map);
		}
		
/*		@Select("SELECT CEIL(count(*)/20.0) from seoul_location") */
		public int seoulTotalPage()
		{
			return mapper.seoulTotalPage();
		}
		
/*		@Select("SELECT * FROM seoul_location WHERE no=#{no}") */
		public SeoulLocationVO seoulDetailData(int no)
		{
			return mapper.seoulDetailData(no);
		}
		
/*		@Select("SELECT no,title,poster,rownum "
				   +"FROM project_food "
				   +"WHERE rownum<=4 AND address LIKE '%'||#{address}||'%'") */
		public List<FoodVO> seoulFoodData(Map map)
		{
			return mapper.seoulFoodData(map);
		}
		
/*		@Select({
			"<script>"
			+"SELECT no,title,poster,num "
			+"FROM (SELECT no,title,poster,rownum as num "
			+"FROM (SELECT no,title,poster "
			+"FROM seoul_location "
			+"<if test=\"ss!='all'\">"
			+"WHERE address LIKE '%'||#{ss}||'%'"
			+"</if>"
			+"ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}"
			+"</script>"
		})*/
		public List<SeoulLocationVO> seoulFindData(Map map)
		{
			return mapper.seoulFindData(map);
		}
}
