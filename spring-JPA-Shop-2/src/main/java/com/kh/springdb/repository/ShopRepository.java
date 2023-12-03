package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.Order;

public interface ShopRepository  extends JpaRepository<Order, Long>{

}