package com.passion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passion.mapper.BoardMapper;
import com.passion.vo.Board;
import com.passion.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Board getBoardById(Long id) {
		return boardMapper.selectBoardById(id);
	}

	@Override
	public List<Board> getBoardAll() {
		
		return boardMapper.selectBoardAll();
	}

	@Override
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}

	@Override
	public long getBoardMaxSeq() {
		return boardMapper.selectBoardMaxSeq();
	}

	@Override
	public List<Board> getBoardList(PageInfo pageInfo) {
	
		return boardMapper.selectBoardList(pageInfo);
	}

	@Override
	public int getBoardCount() {
		return boardMapper.selectBoardCount();
	}



}
