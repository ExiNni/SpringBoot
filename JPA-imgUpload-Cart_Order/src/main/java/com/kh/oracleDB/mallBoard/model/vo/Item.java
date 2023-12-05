package com.kh.oracleDB.mallBoard.model.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item {
	// primary key
	private int id;
	// 상품 이름
	private String name;
	//상품 설명
	private String description;
	//상품 가격
	private int price;
	//판매 개수
	private int count;
	//재고 
	private int stockQuantity;
	//상품 상태 (판매중인지 품절인지 체크해주는 필드)
	private boolean isSale;
	// 상품을 판매하는 판매자가 여러명일 수 있으므로 판매자가 누구인지 아이디를 넣어줘야함
	//판매자 아이디(admin), 상품 사진
	@ManyToOne // 판매자 한명이 여러개의 상품을 팔 수 있기 때문에 판매자 1 : 상품 N
	@JoinColumn(name="admin_id")
	private User admin;
	// 상품 사진
	private String photo;
	// 상품명
	private String photoName; 
	// 상품 이미지 위치
	private String photoPath;
	
	
	
	private List<CartItem> cart_items = new ArrayList<>();
}
