package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.STmemberRepository;
import com.kh.springdb.vo.STMember;

import jakarta.transaction.Transactional;

@Service
public class STmemberService {

	private final STmemberRepository stRepository;

	//생성자
	@Autowired
	public STmemberService(STmemberRepository stRepository) {
		this.stRepository = stRepository;
	}
	
	//전체조회, 값입력, 수정, 삭제
	// 1. 전체조회
	public List<STMember> getAllMember(){
		return stRepository.findAll();
	}
	// 2. 값 입력해서 저장하는 메서드
	@Transactional
	public STMember saveMember(STMember stmember) {
		return stRepository.save(stmember);
	}
	
	// 3. 삭제하는 메서드
	public void deleteMemberById(Long id) {
		stRepository.deleteById(id);
	}
	
	// 4. 아이디 1개만 조회하는 메서드
	public Optional<STMember> getMemberById(Long id){
		return stRepository.findById(id);
	}
}