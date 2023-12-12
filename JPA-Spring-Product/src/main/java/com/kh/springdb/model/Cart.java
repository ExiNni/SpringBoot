package com.kh.springdb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="carts_seq")
	@SequenceGenerator(name="carts_seq", sequenceName="carts_seq", allocationSize=1)
	private Long Id;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>();

	@OneToOne(mappedBy = "cart")
	@JoinColumn(name="order_id")
	private Order order;
	
	private int count;
	
	
	public int getTotalAmount() {
		return cartItems.stream().mapToInt(product -> product.getCount() * Integer.parseInt(product.getProduct().getPrice())).sum();
	}
	
	public int getTotalCount() {
		return cartItems.stream().mapToInt(CartItem::getCount).sum();
	}
	
}