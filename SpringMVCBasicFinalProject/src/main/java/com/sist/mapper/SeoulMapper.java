package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface SeoulMapper {
	@Select("SELECT no,title,poster,num "
		   +"FROM (SELECT no,title,poster,rownum as num "
		   +"FROM (SELECT no,title,poster "
		   +"FROM seoul_location ORDER BY no ASC)) "
		   +"WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulLocationVO> seoulLocationListData(Map map);
	
	@Select("SELECT CEIL(count(*)/20.0) from seoul_location")
	public int seoulTotalPage();
	
	@Select("SELECT * FROM seoul_location WHERE no=#{no}")
	public SeoulLocationVO seoulDetailData(int no);
	
	@Select("SELECT fno,name,poster,rownum "
		   +"FROM food_location "
		   +"WHERE rownum<=4 AND address LIKE '%'||#{address}||'%'")
	public List<FoodVO> seoulFoodData(Map map);
	
	@Select({
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
	})
	public List<SeoulLocationVO> seoulFindData(Map map);
}
