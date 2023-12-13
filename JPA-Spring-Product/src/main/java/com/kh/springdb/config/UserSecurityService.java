package com.kh.springdb.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.SiteUser;
import com.kh.springdb.model.UserRole;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

	private final UserRepository userRepository;
	
	// 유저에 대한 정보를 로그인 할 때
	// userDetails를 사용해서 로그인 할 수 있는 유저가 있는지 확일 할 것
	// 사용자명을 기준으로 사용자 정보를 가져오게 할 것
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<SiteUser> _siteUser = this.userRepository.findByUserName(username);
	        if (_siteUser.isEmpty()) {
	            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
	        }
	        SiteUser user = _siteUser.get();
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        if (user.getIsRole().equals(UserRole.ADMIN)) {
	            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
	        } else {
	            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
	        }
	        return new User(user.getUserName(), user.getPassword(), authorities);
	    }
	}

/*
	DB나 외부에서 로그인하여 인증을 하기 위해서는 인증 처리를 해야함
	
	UserDetailService : 사용자 정보를 인증
	
	UserDetails 메서드
		1. getAuthorities: 사용자가 가지고 있는 권한 목록을 반환, 권한은 정의된 권한에 따라 달라짐, 권한은 개발자가 설정
			권한은 GrantedAuthority 갖고옴
		2. getPassword: 사용자의 비밀번호를 반환, DB에서 암호화 처리된 형태로 저장돼 있음
		3. getUserName: 사용자명을 반환
		4. isEnables: 계정이 활성화 돼있는지 여부를 Boolean값으로 나타냄
		
	
*/