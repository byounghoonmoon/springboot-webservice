package com.passion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.passion.vo.Board;
import com.passion.vo.PageInfo;

@Mapper
public interface BoardMapper {
    Board selectBoardById(Long id);
    List<Board> selectBoardAll();
    List<Board> selectBoardList(PageInfo pageInfo);
    void insertBoard(Board board); 
    Long selectBoardMaxSeq();
    int selectBoardCount();
}