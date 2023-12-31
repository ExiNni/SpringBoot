package com.kh.shop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kh.springdb.vo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	// 메서드 이름으로 간단하게 쿼리를 정의하기
	Product findByProductName(String product_name);
	
	// 전체 제품 출력하는 메서드 추가
	List<Product> findByPriceDesc(Integer Price);
	
	// 만약에 Repository에 쿼리를 추가하고 싶을 경우
	@Query("SELECT * FROM ProductItem WHERE PRICE DESC")
	List<Item> findByDetail(@Param("category") String category);
	
	/*
	public void CreateProductList() {
		Product product = new Product();
		product.setProduct_name("테스터 제품");
		product.setPrice(1000);
		product.setCategory("가전제품");
	}
	*/
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
 */
