package com.kh.springdb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName="user_seq", allocationSize=1)
	@Column(nullable = false, length = 20, unique = true)
	private int id;
	
	//닉네임 중복 방지를 위해 unique
	@Column(nullable = false, length = 20, unique = true)
	private String username;
	@Column(nullable = false, length = 20)
	private String password;
	@Column(nullable = false, length = 10)
	private String name;
	@Column(nullable = false, length = 50)
	private String email;
	private String address;
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	private int coin;
	
	//판매자가 가지고 있는 상품
	private List<Item> items = new ArrayList<>();
	
	//판매자가 판매한 내역 
	//@OneToMany(mappedBy="seller")
	//private List<Sale> sellerSale;
	
	//판매자가 판
	
	//구매자 결제 내역
	
	//구매자 주문 리스트
	
	 //구매자가 사고 싶은 내역의 장바구니
	//Cart라는 장바구니를 이요앻서 장바구니에 아이템을 담을 예정
}