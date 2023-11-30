package com.kh.board.vo;

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
@Table(name="Boards")

public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="board_id_sequence")
	@SequenceGenerator(name="board_id_sequence", sequenceName="board_id_sequence", allocationSize=1)
	@Column(name="board_id")
	private Long board_id;
	@Column(nullable = false, length=50)
	private String title;
	@Column(nullable = false, length=50)
	private String content;
	@Column(nullable = false, length=50)
	private String author;
}

/*
	@Lob: Blob, Clob 타입을 매핑
	@Creation TimeStamp : insert시 시간을 자동으로 저장
	@UpdateTimestamp: update시 시간을 자동으로 저장
	@Temporal: 날짜 타입 매핑
	@CreateDate: 엔티티가 생성되어 저장될 때 시간을 저장
	
	@Column: 테이블 안에 컬럼을 생성하거나 존재하는 테이블에 컬럼값을 찾아 매핑하는 역할을 함
			 option: name - DB에서 존재하는 컬럼이름과 자바 클래스에서 존재하는 필드 이름이 일치하지 않을 경우
			 		 자바 DB 값이 일치할 수 있도록 매핑해주는 역할
			 unique: 유니크 제약 조건 설정
			 insertable: insert 가능 여부
			 updateable: update 가능 여부
			 length: String 타입의 문자 길이 제약조건 설정
			 column Definition: DB 컬럼 정보를 직접 기술 / @Column(column Definition = "varchar(10) not null")
			 precision: 큰 값에서 사용할 수 있음 소수점을 포함한 전체 자리 수
			 scale(DDL): 소수점 자리수 Double과 float 타입에는 적용되지 않음
			 
	@GeneratedValue(strategy = GenerationType.)
			 GenerationType.AUTO(defualt): JPA 자동으로 알아서 생성 전략을 결정
			 GenerationType.SEQUENCE: DB 시퀀스를 이용해서 기본키를 생성, 간혹 @SequenceGenerator를 사용해서 시퀀스를 등록할 필요가 있음
			 GenerationType.TABLE: 키 생성용 테이블 사용 @TableGenerator 가 필요함
			 GenerationType.IDENTITY: 기본키 생성을 DB에 넘겨줌 / mySQL에서 사용 / mySQL DB의 경우 AUTO_INCREMENT 사용해서 기본키를 생성
 */