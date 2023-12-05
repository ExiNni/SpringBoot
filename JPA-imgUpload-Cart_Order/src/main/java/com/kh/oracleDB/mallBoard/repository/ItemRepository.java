package com.kh.oracleDB.mallBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.oracleDB.mallBoard.model.vo.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
