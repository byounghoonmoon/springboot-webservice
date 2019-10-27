package com.rubypaper.persitence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository  extends CrudRepository<Board, Long> {
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByContentContainingOrTitleContaining(String key1, String key2);
	List<Board> findByContentContainingOrderBySeqDesc(String searchKeyword);
	Page<Board> findByTitleContaining(String keyword, Pageable paging);
	
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String keyword);
	
	@Query("SELECT b FROM Board b " 
	+ "WHERE b.title like %:a% "
	+ "ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1_1(@Param("a")String keyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b " 
	+ "WHERE b.title like %:a% "
	+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("a")String keyword);
	

	@Query(value="SELECT seq, title, writer, create_date from board " 
	+ "WHERE title like '%'||?1||'%' "
	+ "ORDER BY seq DESC", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String keyword);
	

	@Query(value="SELECT * from board ORDER BY seq DESC", nativeQuery=true)
	List<Object[]> queryAnnotationTest4(Pageable paging);
			
			
			
}
