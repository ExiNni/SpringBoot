package com.kh.oracleDB.mallBoard.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

import org.springframework.format.annotation.*;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName="order_seq",allocationSize=1)
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user; // 구매자

  @OneToMany(mappedBy = "orders")
  private List<OrderItem> orderItems = new ArrayList<>();

  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private LocalDate createDate; // 구매 날짜

  @PrePersist
  public void createDate() {
      this.createDate = LocalDate.now();
  }

  public void addOrderItem(OrderItem orderItem) {
      orderItems.add(orderItem);
      orderItem.setOrders(this);
  }

  public static Orders createOrder(User user, List<OrderItem> orderItemList) {
      Orders orders = new Orders();
      orders.setUser(user);
      for (OrderItem orderItem : orderItemList) {
    	  orders.addOrderItem(orderItem);
      }
      orders.setCreateDate(orders.createDate);
      return orders;
  }

  public static Orders createOrder(User user) {
      Orders orders = new Orders();
      orders.setUser(user);
      orders.setCreateDate(orders.createDate);
      return orders;
  }

}