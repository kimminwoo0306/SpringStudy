package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface CampDAO extends JpaRepository<CampEntity,Integer>{
   @Query(value="SELECT * FROM camp "
		       +"WHERE address LIKE CONCAT('%',:address,'%') ORDER BY cno LIMIT :start,30",nativeQuery = true)
   public List<CampEntity> campFindData(@Param("address") String address,@Param("start") Integer start);
   
   @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM camp "
		       +"WHERE address LIKE CONCAT('%',:address,'%')",nativeQuery = true)
   public int campFindTotalPage(String address);
   
   @Query(value="SELECT * FROM camp ORDER BY cno DESC LIMIT :start,50",nativeQuery = true)
   public List<CampEntity> campListData(@Param("start") Integer start);
   
   @Query(value="SELECT CEIL(COUNT(*)/50.0) FROM camp ",nativeQuery = true)
public int campTotalPage();
   
   public CampEntity findByCno(@Param("cno")Integer cno);
   
   @Query(value="SELECT * FROM camp ORDER BY cno DESC",nativeQuery = true)
   public List<CampEntity> campTop20();
  
}