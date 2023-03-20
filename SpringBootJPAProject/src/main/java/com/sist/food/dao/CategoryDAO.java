package com.sist.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.food.entity.CategoryEntity;
import java.util.*;
public interface CategoryDAO extends JpaRepository<CategoryEntity,Integer>{
	@Query(value="SELECT cno,title,subject,poster,link FROM project_category",nativeQuery=true)
	 public  List<CategoryEntity> categoryListData();
}
