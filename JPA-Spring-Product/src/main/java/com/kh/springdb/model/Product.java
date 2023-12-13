package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq", sequenceName="product_seq", allocationSize=1)
	private Long id;
	
	private String name;
	private String text;
	private String price;
	private int count;
	private int stock;
	private int isSoldOut;
	
	// 댓글 작성을 위한 Comment
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@Column(nullable=true)
	private String imgName;
	@Column(nullable=true)
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
	// 제품에 대한 좋아요를 받고 싶다면 여기에 추천과 관련된 변수를 넣어줘도 됨
	//private int like; // 좋아요를 받는 방법은 여러 방법이 있음
	// 1. 사용자 관계없이 카운트만 올라가게 하기
	
	// 2. ManyToOne이나 OneToMany 이용해서 서로 카운트 주기
	
}