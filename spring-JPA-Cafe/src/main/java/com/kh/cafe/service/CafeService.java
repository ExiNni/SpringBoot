package com.kh.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.cafe.repository.CafeRepository;
import com.kh.cafe.vo.Cafe;

@Service
public class CafeService {

	private final CafeRepository cafeRepository;
	
	@Autowired
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	
	public List<Cafe> getAllCafes(){
		return cafeRepository.findAll();
	}
	
	public Optional<Cafe> getCafeById(Long id){
		return cafeRepository.findById(id);
	}
	
	public Cafe saveCafe(Cafe cafe) {
		return cafeRepository.save(cafe);
	}
	
	public void deleteCafeById(Long id) {
        cafeRepository.deleteById(id);
    }
	
	public void deleteAllCafe() {
		cafeRepository.deleteAll();
	}
	
	public List<Cafe> findCafe(String keyword) {
        List<Cafe> cafes = cafeRepository.findCafe(keyword);
        return cafes.isEmpty() ? getAllCafes() : cafes;
    }
	
	// repository에 작성한 지역카운터를 가져와서 이용할 수 있는 메서드를 추가
	public int countCafeByLocation(String location) {
		return cafeRepository.countByLocation(location);
	}
	
	// 카페가 존재하는지 존재 여부
	public boolean existsCafeByName(String name) {
		return cafeRepository.existsByName(name);
	}
}
