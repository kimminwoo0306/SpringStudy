package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;


public interface RecipeMapper {
	@Select("SELECT no, title, poster, chef, num "
			+ "FROM (SELECT no, title, poster, chef, rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no, title, poster, chef "
			+ "FROM recipe)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe")
	public int recipeTotalPage();
	
	@Select("SELECT TO_CHAR(COUNT(*),'999,999') FROM recipe")
	public String recipeRowCount();
	
	// 쉐프의 작품 출력
	@Select("SELECT no,title,poster,chef,rownum "
			+ "FROM recipe "
			+ "WHERE chef=#{chef} AND rownum <= 20")
	public List<RecipeVO> chefMakeRecipeData(String chef);
}
