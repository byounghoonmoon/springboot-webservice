package com.rubypaper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAClient {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			
			/*
			//	글등록 테스트
			tx.begin();
			Board board = new Board();
			board.setTitle("JPA Study");
			board.setWriter("Bo2");
			board.setContent("JPA Write Content Success!");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			em.persist(board);
			tx.commit();
			
			
			// 글 조회
			Board searchBoard = em.find(Board.class, 3L);
			System.out.println(searchBoard.toString());
			
			
			// 글 삭제
			Board board = em.find(Board.class, 1L);
			em.remove(board);
			tx.commit();
			
			*/
			String jpql ="select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql,Board.class).getResultList();
			for(Board rst : boardList)
				System.out.println(" ## " + rst.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if(em!=null)	em.close();
			if(emf!=null)	emf.close();
		}
		
		
	}
}
