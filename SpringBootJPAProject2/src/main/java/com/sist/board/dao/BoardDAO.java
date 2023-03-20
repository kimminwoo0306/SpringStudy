package com.sist.board.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.board.entity.BoardEntity;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity,Integer>{
	public BoardEntity findByNo(@Param("no") Integer no); // 상세보기
	// SELECT * FROM board WHERE no=
	// findByName (@Param("name") String name);, findByNameLike(String name) => WHERE name= or subject -
	// 자동 : save, remove
	// 검색 : findBy(column)
	// @Query
	@Query(value="SELECT no,name,subject,content,pwd,regdate,hit "
			+ "FROM board ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery=true)
	public List<BoardEntity> boardListData(@Param("start") int start);
	
	@Query(value="SELECT CEIL(COUNT(*)/10.0) FROM board",nativeQuery=true)
	public int boardTotalPage();
	
	// save (insert, update)
	// delete
}
