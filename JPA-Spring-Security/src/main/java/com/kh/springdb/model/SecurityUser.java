package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SecurityUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "securityUser_seq")
	@SequenceGenerator(name = "securityUser_seq", sequenceName = "securityUser_seq", allocationSize = 1)
	@Column(unique = true)
	private Long id;
	@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
}
