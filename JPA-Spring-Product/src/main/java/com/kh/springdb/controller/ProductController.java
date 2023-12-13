package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Product;
import com.kh.springdb.service.CommentService;
import com.kh.springdb.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final CommentService commentService;
	
	@GetMapping("/")
	public String mainPageView(Model model) {
		List<Product> products = productService.allProductView();
		model.addAttribute("products", products);
		return "index";
	}
	
	// 페이지네이션 체크를 하기 위한 GetMapping 추가
	@GetMapping("/list")
	public String pageList(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		// @RequestParam(value="page", defaultValue="0")
		// 어떤 값을 가지고 요청을 할지 지정하기 위해 @RequestParam 이용했음
		// value = "page" 값으로 page 이름을 받기로 지정 만약에 초반이나 후반에 어떤 값이 page 안에 없다면 page가 null 값이라면
		// 기본 값으로 0으로 설정해서 초기값을 null이 아닌 0으로 처리하겠다
		// 페이지는 배경값으로 0이지만 변수에는 추후 1이 할당될 예정
		// 페이지에는 1로 표기가 되지만 코드안에서는 0부터 시작하는 것으로 표기를 해줘야함
		Page<Product> paging = productService.getList(page);
		model.addAttribute("paging", paging);
		return "product_list";
	}
	
	@GetMapping("/product/list")
	public String productList(Model model) {
		List<Product> products = productService.allProductView();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@GetMapping("/product/new")
	public String productSaveForm(Model model) {
		return "addProductForm";
	}
	
	@PostMapping("/product/new")
	public String productSave(Product product, MultipartFile imgFile) throws IllegalStateException, IOException {
		productService.saveProduct(product, imgFile);
		return "redirect:/product/list";
	}
	
	@GetMapping("/product/detail/{id}")
	public String productDetail(@PathVariable() int id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productDetail";
	}
	
	// 댓글 작성하기 위한 postMapping
	@PostMapping("/addComment")
	public String addComment(@RequestParam Long productId, @RequestParam String commentContent) {
		commentService.addComment(productId, commentContent);
		return "redirect:/product/detail/" + productId;
	}
	
	 @PostMapping("/deleteComment/{commentId}")
	    public String deleteComment(@PathVariable Long commentId, @RequestParam Long productId) {
	        commentService.deleteComment(commentId);
	        return "redirect:/product/detail/" + productId;
	    }
	 
//	 @PostMapping()
//	 public String likeProduct() {
//		 	productService.likeProduct(0);
//		 	return "redirect:/list";
//		 }
	 
}	