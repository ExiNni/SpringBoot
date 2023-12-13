package com.kh.springdb.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// 사용자 ID나 비밀번호 이메일을 회원가입 할 때 필수로 넣어줬는지 확인
@Getter
@Setter
public class UserCreateForm {
	@Size(min = 3, max = 23)
	@NotEmpty(message = "사용자ID는 필수로 기입합니다.")
	private String username;
	
	@Email
	@NotEmpty(message = "이메일은 필수입니다.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수입니다.")
	private String password;
	
	@NotEmpty(message = "비밀번호 확인은 필수입니다.")
	private String password2;
	
	
	
	
}
