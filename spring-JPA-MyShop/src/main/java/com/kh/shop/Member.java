package com.kh.shop;

import jakarta.persistence.Entity;
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
	@GeneratedValue()
}
