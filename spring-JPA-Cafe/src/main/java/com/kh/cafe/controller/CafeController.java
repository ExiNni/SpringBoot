package com.kh.cafe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.cafe.service.CafeService;
import com.kh.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafe")
public class CafeController {
	private final CafeService cafeService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	@GetMapping
	public String getAllCafes(Model model) {
		List<Cafe> cafe = cafeService.getAllCafes();
		model.addAttribute("cafe", cafe);
		return "cafe_list";
	}
	
	@GetMapping("/detail/{id}")
	public String getCafeById(@PathVariable Long id, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(id);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafe_detail";
	}
	
	@GetMapping("/new")
	public String displayCafeForm(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	
	@PostMapping("/save")
	public String saveCafe(@ModelAttribute Cafe cafe) {
		cafeService.saveCafe(cafe);
		return "redirect:/cafe";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateCafe(@PathVariable Long id, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(id);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafeForm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCafe(@PathVariable Long id) {
	    cafeService.deleteCafeById(id);
	    return "redirect:/cafe";
	}
	
	@GetMapping("/delete/all")
	public String deleteAllCafes() {
		cafeService.deleteAllCafe();
		return "redirect:/cafe";
	}
	
	@GetMapping("search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		// 특정 키워드를 포함하는 카페를 검색
		List<Cafe> cafe = cafeService.findCafe(keyword);
		// 모델에 검색 결과 추가
		model.addAttribute("cafe", cafe);
		// 검색 결과를 보여줄 뷰 페이지 작성
		return "searchResult";
	}
}
