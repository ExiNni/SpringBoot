package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
// 공통으로 들어가는 url 이 있다면 RequestMapping 사용해서 user로 묶어주기
public class UserController {
	
	private final UserService userService;
	
	// 회원가입 창
	@GetMapping("/signup")
	public String signUp(UserCreateForm userCreateForm) {
		return "signupForm";
	}
	
	// 회원가입에 대한 postMapping
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		
		if(!userCreateForm.getPassword().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}
		userService.createUser(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword());
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
}
