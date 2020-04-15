package com.passion.service;

import java.util.List;

import com.passion.vo.Board;
import com.passion.vo.PageInfo;

public interface BoardService {

	Board getBoardById(Long id);
	List<Board> getBoardAll();
	List<Board> getBoardList(PageInfo pageInfo);
	
	void insertBoard(Board board);
	long getBoardMaxSeq();
	
	int getBoardCount();

}