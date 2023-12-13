package com.kh.springdb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.SiteUser;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입을 할 경우 계정을 생성해주기 위해 service를 만들어줌
	// 기존 서비스에서 했던 회원가입과 조금 다른 점은
	// 비밀번호를 암호화 처리해서 저장해주는 것이 조금 다름
	
	public SiteUser createUser(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		
		userRepository.save(user);
		return user;
	}
}