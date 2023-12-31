package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.Board;
import com.kh.springdb.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "board-list";
	}
	
	@GetMapping("/{board_id}")
	public String getBoardById(@PathVariable int board_id, Model model) {
		Board board = boardService.getBoardById(board_id);
		model.addAttribute("board", board);
		return "board-detail";
	}
	
	// 게시글 작성
	@GetMapping("/create") // HTTP GET 요청이 /create 라는 경로로 들어올 때 호출
	public String displayCreateForm(Model model) { // Model 객채를 매개변수로 받아서 templates(view)으로 데이터를 전달할 수 있음
		model.addAttribute("board", new Board());
		// new Board로 새로운 Board 객체를 생성해서 모델에 추가
		return "board-form"; // board-form.html 템플릿에서 해당 view를 보여줌
	}
	
	// 
	@PostMapping("create")
	public String createBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards"; // 글이 작성된 후 돌아갈 템플릿 작성
	}
	
	@PostMapping("/update/{boardId}")			// Post 는 @ModelAttribute 값을 전달해야해서
	public String UpdateForm(@PathVariable int board_id, @ModelAttribute Board board) {
		
		// URL에서 가져온 boardId값을 Board 객체에 저장 /수정한 내용을 setBoardId 통해 저장
		board.setBoard_id(board_id);
		boardService.updateBoard(board);
		
		// 수정이 완료된 후 게시글 목록 페이지로 돌아가기
		return "redirect:/boards";
	}
	
	@GetMapping("/update/{boardId}")								// GET 은 Model model
	public String displayUpdateForm(@PathVariable int board_id, Model model) {
		Board board = boardService.getBoardById(board_id);
		model.addAttribute("board",board);
		return "board-form";
	}
	
	@GetMapping("/delete/{board_id}")
	public String deleteBoard(@PathVariable int board_id) {
		boardService.deleteBoard(board_id);
		return "redirect:/boards";
	}
	
	// 게시글 모두 삭제
	@GetMapping("/delete-all-boards")
	public String deleteAllBoards() {
		boardService.deleteAllBoards();
		return "redirect:/boards";
	}
}

/*
 * Model model: 컨트롤러에서 뷰로 데이터를 전달할 떄 사용하는 인터페이스
 * 				컨트롤러에 있는 메서드에서 매개변수로 Model을 선언하면 Get에 추가한 데이터는 자동으로 뷰에 전달됨
 * 				Select 에서 데이터베이스에서 담겨온 데이터는 자동으로 모델에 담겨져 View(html) 파일로 전달됨
 *  
 * @ModelAttribute: 클래스이름 클래스를 대신할 변수명 // @ModelAttribute Board board
 *					폼 데이터나 URL 경로에서 전달된 데이터를 객체에 넣어줄 때 사용
 *					클라이언트에서 전송한 데이터를 객체로 			
 */
