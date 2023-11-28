package com.kh.springdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.service.ProductService;
import com.kh.springdb.vo.Product;

//@RestController
@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
		
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public String getAllProducts(Model model){
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		// return productService.getAllProducts();
		return "product_list";
	}
	
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_detail";
	}
}
