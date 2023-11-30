package com.kh.cafe.vo;

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
@Getter
@Setter
@Table(name="Cafe")
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cafe_id_sequence")
	@SequenceGenerator(name="cafe_sequence", sequenceName="cafe_id_sequence", allocationSize=1)
	@Column(name="cafe_id")
	private Long cafe_id;
	@Column(nullable = false, length=50)
	private String name;
	@Column(nullable = false, length=50)
	private String location;
	@Column(nullable = false, length=50)
	private String operating_hour;
}
