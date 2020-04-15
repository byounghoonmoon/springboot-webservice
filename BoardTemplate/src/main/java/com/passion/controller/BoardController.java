package com.passion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.passion.service.BoardService;
import com.passion.vo.Board;
import com.passion.vo.PageInfo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String getIndex(Model model, PageInfo pageInfo) {
		int totCnt = boardService.getBoardCount();
		
		pageInfo.setTotCnt(totCnt);
		pageInfo.setTotPage(totCnt/pageInfo.getPagePerCnt()+1);
		pageInfo.setCurrentPage(1);
		pageInfo.setEndPage(pageInfo.getPageNavCnt());
		pageInfo.setLastPage(totCnt/pageInfo.getPagePerCnt()+1);
		
		model.addAttribute("pageInfo", pageInfo);
		return "index";
	}

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, PageInfo pageInfo) {

		System.out.println(pageInfo.toString());
		int totCnt = boardService.getBoardCount();
		int lstPage = ( totCnt/pageInfo.getPagePerCnt() )  +  1;
		pageInfo.setTotCnt(totCnt);
		pageInfo.setLastPage(lstPage);
		pageInfo.setEndPage(lstPage);
		
		System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
		System.out.println(pageInfo.toString());
		List<Board> boardList = boardService.getBoardList(pageInfo);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView() {

		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard( Board board) {

		
		if(board.getSeq()==null || board.getSeq().equals("") ) {

			System.out.println(" ■■■■■■■■■■■■ Param ■■■■■■■■■■■■■■■■■ ");
			Long seq = boardService.getBoardMaxSeq();
			System.out.println(seq);
			board.setSeq(seq);

			System.out.println(board.toString());
			System.out.println(" ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ ");
		}
		
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard( Board board, Model model) {

		return "getBoard";
	}

}
