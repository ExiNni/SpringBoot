package com.kh.shop.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member {
	@Id
	@Column (name="member_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberId_Seq")
	@SequenceGenerator(name = "memberId_Seq", sequenceName="memberId_Seq", allocationSize = 1)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String address;
	
}
