package com.kh.springdb.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ProductItem")
public class Product {
	@Id
	@Column(name="product_id")
	private Long product_id;
	@Column(nullable = false, length=50)
	private String product_name;
	@Column(nullable = false, length=50)
	private String category;
	@Column(name="price")
	private int price;
}


/*
	@Table: 데이블 이름을 지정
	@Id: 해당 필드가 엔터티의 primaryKey 임을 나타냄
	@Column: 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음
	
	nullable: 해당 컬럼이 null 값을 허용하는지 여부를 나타냄
	length: 문자열 컬럼에 최대 길이를 지정
	String: 시작되는 필드 값의 경우 String으로 지정된 이름으로 명시되기 떄문에 띠로 name을 지정해주지 않아도 되지만
			String 이외 값은 name을 설정해주어 Column 명을 지정해주는 것이 원칙
	
 */
