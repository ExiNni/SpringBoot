package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.mapper.BoardMapper;
import com.kh.springdb.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<Board> getAllBoards(){
		return boardMapper.getAllBoards();
	}
	
	public Board getBoardById(int board_id) {
		return boardMapper.getBoardById(board_id);
	}
	
	public void saveBoard(Board board) {
		boardMapper.insertBoard(board);
	}
	
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}
	
	public void deleteBoard(int board_id) {
		boardMapper.deleteBoard(board_id);
	}
	
	@Transactional
	public void deleteAllBoards() {
		boardMapper.deleteAllBoards();
	}
}

/*
 * @Transactional
 * 트랜젝션을 지원하는 스프링에서 데이터베이스 관리를 단순히 어노테이션을 사용해서 
 * 여러개의 데이터베이스 조작 작업을 묶어서 하나의 작업 단위로 처리하는데 사용하며
 * 작업은 성공 또는 실패로 완료될 수 있다.
 * 
 *  개발자가 일일이 커밋 또는 롤백을 관리하는 코드를 작성하지 않아도 됨
 */
