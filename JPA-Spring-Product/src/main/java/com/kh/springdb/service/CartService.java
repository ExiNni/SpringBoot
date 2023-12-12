package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.CartItem;
import com.kh.springdb.model.Order;
import com.kh.springdb.model.Product;
import com.kh.springdb.repository.CartItemRepository;
import com.kh.springdb.repository.CartRepository;
import com.kh.springdb.repository.OrderRepository;
import com.kh.springdb.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
//@RequiredArgsConstructor
public class CartService {
	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public List<CartItem> findCartItemByCartId(int cartId) {
		return cartItemRepository.findCartItemByProductId(cartId);
	}

	public List<CartItem> findByProductId(int productId) {
		return cartItemRepository.findByProductId(productId);
	}

	public Cart getCartById(Long cartId) {
		return cartRepository.findById(cartId).orElse(null);
	}

	@Transactional
	public void addCart(Long cartId, Product newProduct, int amount) {
		// 현재 담긴 장바구니가 없을 때 장바구니 생성해주는 코드
		Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
			Cart newCart = new Cart();
			return cartRepository.save(newCart);
		});

		// 장바구니에 해당 아이템이 이미 담겨져 있는지 확인
		CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId, newProduct.getId());

		if (cartItem == null) {
			// 장바구니에 해당 아이템이 없으면 새로운 CartItem 생성
			cartItem = new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(newProduct);
			cartItem.setCount(amount);
		} else {
			// 장바구니에 해당 아이템이 이미 담겨져 있으면 수량 증가
			cartItem.addCount(amount);
		}

		// 생성 또는 업데이트된 CartItem을 저장
		cartItemRepository.save(cartItem);

	}

	
	
	//결제하기
	@Transactional
	public void checkout(Long cartId) {
		//주문할 아이템 정보를 찾기 위해 cart Entity 정보를 가지고 옴
		Cart cart = cartRepository.findById(cartId).orElse(null);
		//Cart 어떤 유저가 장바구니에 물건을 담았는지
		// user -cart 를 연결해주는 역할을 함
		
		//CartItem - 장바구니에 어떤 아이템이 담겼는지
		// cart - Item : 연결해놓은 역할을 함 
		
		//만약에 카드가 null값이 아닐 때 
		if(cart != null) {
			//order 객체를 가지고 옴 
			//Order order = Order     + cart(cart).build();
			Order order = Order.builder().cart(cart).build();
			
			//결제 이후 문제가 생길 것을 대비해서 데이터베이스 안에도 
			//주문한 사람과 주문 내역 날짜와 같은 주문 내역을 저장할 예정 
			orderRepository.save(order);
			
			//delete와 clear
			
			cart.getCartItems().clear();
			cartRepository.save(cart);
			cartItemRepository.deleteAll();
			cart.getCartItems().clear();
		}
		
	}
	
}