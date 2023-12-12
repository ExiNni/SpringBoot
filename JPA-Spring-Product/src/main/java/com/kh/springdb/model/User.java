package com.kh.springdb.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//public class User {
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
//	@SequenceGenerator(name="users_seq", sequenceName="users_seq", allocationSize=1)
//	private int id;
//	
//	@Column(unique=true)
//	private String userName;
//	
//	private String password;
//	private String name;
//	private String email;
//	private String address;
//	private String phone;
//	private String role; 
//	
//	private int coin;
//	
//	private List<Item> items = new ArrayList<>();
	
	// 판매자가 판매한 내역 > Sale 생성 후 주석 해제
//	@OneToMany(mappedBy = "seller")
//	private List<Sale> sellerSale;
	
	// 판매자가 판매한 상품들 > SaleItem 생성 후 주석 해제
//	@OneToMany(mappedBy = "seller")
//	private List<SaleItem> sellerSaelItem = new ArrayList<>();
	
	//구매자 결제 내역
	
	//구매자 주문 리스트
	
//	구매자가 사고싶은 내역의 장바구니*/
//}