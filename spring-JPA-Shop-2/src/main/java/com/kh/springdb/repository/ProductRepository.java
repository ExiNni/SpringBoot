package com.kh.springdb.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kh.springdb.vo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}

/*
	Repository
	Spring Data JPA에서 제공하는 인터페이스 
	DB에서 User 엔터티에 접근하는데 사용
	기본적인 CRUD 작업을 수행할 수 있는 메서드를 제공
	
	예를 들어
	조회: 전체조회(findAll)  / 아이디 하나만 조회(findById)
	저장: save
	삭제: deleteById
	
	findOne: 조건에 해당하는 엔터티 중에서 첫 번째 엔터티만 반환
			 조건에 해당하는 엔터티가 없으면 null을 반환
	
	findById: 일반적으로 프라이머리 키에 해당하는 엔터티를 찾아서 반환
			  Optional Optional.empty() = 빈 값으로 반환 처리를 할 수 있음
			  JPA 2.0 이후로 출시된 findOne 보다는 최신 버전
 */
