package com.kh.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.board.repository.BoardRepository;
import com.kh.board.vo.Board;

@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public List<Board> getAllBoards(){
		return boardRepository.findAll();
	}
	
	public Optional<Board> getBoardById(Long id){
		return boardRepository.findById(id);
	}

	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}
	
	public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
	
	public void deleteAllBoard() {
		boardRepository.deleteAll();
	}
	
	// 특정 검색어로 검색하는 메서드
	 public List<Board> findBoardByTitle(String keyword) {
	        return boardRepository.findTitle(keyword);
	    }
}
