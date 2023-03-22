package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface FoodLocationDAO extends JpaRepository<FoodLocationEntity,Integer>{
   @Query(value="SELECT * FROM food_location "
		       +"WHERE address LIKE CONCAT('%',:address,'%') ORDER BY fno LIMIT :start,20",nativeQuery = true)
   public List<FoodLocationEntity> foodFindData(@Param("address") String address,@Param("start") Integer start);
   
   @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM food_location "
		       +"WHERE address LIKE CONCAT('%',:address,'%')",nativeQuery = true)
   public int foodFindTotalPage(String address);
   
   public FoodLocationEntity findByFno(@Param("fno")Integer fno);
   
   @Query(value="SELECT * FROM food_location ORDER BY fno DESC LIMIT 0,20",nativeQuery=true)
   public List<FoodLocationEntity> foodTop20();
}