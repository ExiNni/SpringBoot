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
	
}
