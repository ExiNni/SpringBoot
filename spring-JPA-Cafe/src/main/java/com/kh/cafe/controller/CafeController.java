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

	// @RequestParam(required=false): 파라미터를 필수로 적어주지 않아도 됨을 나타냄
	// @RequestParam http 오청으로 파라미터를 메서드의 메개변수로 전달할 때 사용
	// 클라이언트가 웹 애플리케이션에 보내는 요청의 파라미터 값을 받아서 처리하는데 사용
	// @PathVariable 과 @RequestParam의 차이
	// @PathVariable: URL경로에서 변수 값을 추출 url / cafe / {id}
	// @RequestParam: 한 경로 안에서 클라이언트가 요청한 파라미터 값을 추출 url/cafe?name=사용자가 폼에 입력한 값
	@GetMapping
	public String getAllCafe(Model model, @RequestParam(required = false) String name) {
		// 카페 리스트를 만들어준 후
		// 만약에 리스트에서 카페가 존재한다면 그 카페 목록들만 보여주고
		// 만약에 존재하지 않는다면 그냥 모든 카페 내용을 보여주겠다
		List<Cafe> cafe;
		if (name != null && !name.isEmpty()) {
			cafe = cafeService.findCafe(name);
		} else {
			cafe = cafeService.getAllCafes();

		}
		model.addAttribute("cafe", cafe);
		return "cafe_list";
	}

	// GetMapping을 활용해서 count해준 location을 가지고오기
	@GetMapping("/count")
	public String countCafeByLocation(@RequestParam("location") String location, Model model) {
		int cafeCount = cafeService.countCafeByLocation(location);
		model.addAttribute("location", location);
		model.addAttribute("cafeCount", cafeCount);
		return "cafeCount";
	}
	
	// 카페가 존재하는지 확인 여부
	@GetMapping("/exists/{name}")
	public String existsCafeByName(@PathVariable String name, Model model) {
		boolean cafeExists = cafeService.existsCafeByName(name);
		model.addAttribute("cafeExists", cafeExists);
		return "cafeExists";
	}
}