package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{

	String memberId;
	String memberPw;
	String memberName;
	String memberPhone;
	String memberAddr;
	String responsibility;
	String image;
	String memberRole;
	
	
	// 권한 체크 => 시큐리티가 return값으로 권한 체크를함
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(memberRole));
		return list;
	}
	
	// 로그인 체크
	@Override
	public String getPassword() {
		return memberPw;
	}
	// 로그인 체크
	@Override
	public String getUsername() {
		return memberId;
	}
	
	// 여기서부터 하나라도 false있으면 로그인안됨
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// 5회 시도했을때 잠글수있는것
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// 6개월뒤에 삭제할수있게하는것
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
