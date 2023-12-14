package com.kh.springdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
	@SequenceGenerator(name = "comments_seq", sequenceName = "comments_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private String content;
	
	@ManyToOne 
    @JoinColumn(name = "user_id")
    private SiteUser user;
	
	// 댓글에 좋아요를 누르고 싶다면 댓글 객체로 와서 추천에 관련된 필드를 설정해주면 됨
	
}

/*
	
*/