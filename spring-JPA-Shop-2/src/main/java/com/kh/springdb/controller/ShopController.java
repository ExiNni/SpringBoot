package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springdb.service.ShopService;
import com.kh.springdb.vo.Order;
import com.kh.springdb.vo.Payment;
import com.kh.springdb.vo.Product;
// 월요일에 CartController 따로 만듬
// 주문과 결제 만 하는곳 (그 이상 X)
public class ShopController {
	@Autowired
	private ShopService shopService;

	public ShopController(ShopService shopService) {
		this.shopService = shopService;
	}

	// 주문에 관련된 내용을 처리하는 메서드
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody Product product, int quantity, Model model) {
		// 주문을 쳐리하고 주문한 결과를 Order에 반환하겠다.
		shopService.placeOrder(product, quantity);
		
		// 여기서 model에 필요한 데이터를 추가
		model.addAttribute("msg", "주문이 성공적으로 전달 되었습니다.");
		// 주문확인 페이지로 이동
		return "redirect:/orderCheck";
	}
	@Controller
	public class YourController {

	    private final ShopService shopService;

	    @Autowired
	    public YourController(ShopService shopService) {
	        this.shopService = shopService;
	    }

	    // Other controller methods...

	    @PostMapping("/paymentFinish")
	    public String processPayment(@RequestParam Long orderId, @RequestParam String paymentStatus, Model model) {
	        Order order = shopService.getOrderById(orderId);
	        if (order != null) {
	            Payment payment = shopService.savePayment(order, paymentStatus);
	            if (payment != null) {
	                model.addAttribute("msg", "결제가 성공적으로 처리되었습니다.");
	                return "redirect:/";
	            } else {
	                model.addAttribute("msg", "결제 처리에 실패했습니다.");
	                // Handle failure scenario
	            }
	        } else {
	            model.addAttribute("msg", "주문을 찾을 수 없습니다.");
	        }
	        return "errorPage";
	    }
	}
	
	
	
}


/*

@RequestBody  : 정보를 url이 아니라 자바 객체로 받음
				요청했던 body에 위치하도록 할 때 사용
				
@RequestParam : 정보를 url에 저장함


*/