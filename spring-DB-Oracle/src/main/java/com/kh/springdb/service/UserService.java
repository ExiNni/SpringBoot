package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.UserMapper;
import com.kh.springdb.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	// 전체 회원 조회 가져오기
	public List<User> getAllUsers(){
		return userMapper.getAllUsers();
	}
	
	public User getUserById(int id){
		return userMapper.getUserById(id);
	}
	
	// 한 명의 회원 정보 DB에 저장하기
	public void registerUser(User user) {
		userMapper.insertUser(user);
	}
	
	public User loginUser(int id, String name) {
		return userMapper.loginUser(id, name);
	}
	
}
