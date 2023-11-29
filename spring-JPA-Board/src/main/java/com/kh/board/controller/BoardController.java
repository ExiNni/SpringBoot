package com.kh.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> board = boardService.getAllBoards();
		model.addAttribute("board", board);
		return "board_list";
	}
	
	@GetMapping("/detail/{id}")
		public String getBoardById(@PathVariable Long id, Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_detail";
	}
	
	@GetMapping("/new")
	public String displayBoardForm(Model model) {
		model.addAttribute("board", new Board());
		return "boardForm";
	}
	
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/board";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateBoard(@PathVariable Long id, Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "boardForm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
	    boardService.deleteBoardById(id);
	    return "redirect:/board";
	}
	
	@GetMapping("/delete/all")
	public String deleteAllBoards() {
		boardService.deleteAllBoard();
		return "redirect:/board";
	}
}