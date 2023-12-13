package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
	@SequenceGenerator(name="users_seq", sequenceName="users_seq", allocationSize=1)
	private Long id;
	
	@Column(unique=true)
	private String userName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	
	
	
	// 추천인을 넣고 싶다면 추천자를 생성해서 넣어도 됨
	
	
	
//	private List<Item> items = new ArrayList<>();
	
	 //판매자가 판매한 내역 > Sale 생성 후 주석 해제
//	@OneToMany(mappedBy = "seller")
//	private List<Sale> sellerSale;
	
	//판매자가 판매한 상품들 > SaleItem 생성 후 주석 해제
//	@OneToMany(mappedBy = "seller")
//	private List<SaleItem> sellerSaelItem = new ArrayList<>();
	
	//구매자 결제 내역
	
	//구매자 주문 리스트
	
	//구매자가 사고싶은 내역의 장바구니
}