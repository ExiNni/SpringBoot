package com.kh.springdb.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN"),
	Guest("ROLE_GUEST");
	
	// 현재 유저가 ADMIN인지 USER인지 로그인하기 전까지 파악되지 않기 때문에
	// value 에 ADMIN 또는 USER를 넣어줌
private String value;
	
	UserRole(String value){
		this.value = value;
	}
	
}

/*
 	변수 - 변할 수 있는 수
	상수 - 언제나 할결같은 수
	public static final
	private static final
	private final
	
	enum - final 상수 집합을 나타낼 때 사용하는 값
	
	나열해야하는 상수들은 ,(comma) 사용
	나열을 종료할 때는 ; 사용
	
 */