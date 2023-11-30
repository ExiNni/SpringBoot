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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 특정 키워드를 활용해서 게시물 검색하는 Mapping 메서드
	@GetMapping("/search")
    public String searchBoards(@RequestParam String keyword, Model model) {
        // 특정 키워드를 포함하는 게시물 검색
        List<Board> board = boardService.findBoardByTitle(keyword);

        // 모델에 검색 결과 추가
        model.addAttribute("board", board);

        // 검색 결과를 보여줄 뷰 페이지 리턴
        return "searchResult";
    }
}

/*
	@RequestParam: Spring 프레임워크에서 클라이언트로부터 전송된 HTTP 요청의 파라미터 값을 받아오기 위해
	사용되는 어노테이션 주로 웹 요청에서 쿼리 파라미터나 폼 데이터를 추출하는데 사용
	클라이언트가 전송한 요청의 파라미터 값을 메서드의 매개변수로 받아올 때 사용
	
	예제 코드: @GetMapping("/ex")
	public String paramMethod(@RequestParam String name, @RequestParam int age){
		// name 과 age 는 클라이언트가 전송한 요청의 쿼리 파라미터 값
		   return "View";
	}
 */
