package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
	List<CartItem> findCartItemByProductId(int id);
	CartItem findCartItemById(int id); 
	
	List<CartItem> findByProductId(int productId);
	
	CartItem findByCartIdAndProductId(Long cartId, Long productId);
	
	List<CartItem> findByCartId(Long cartId);
}