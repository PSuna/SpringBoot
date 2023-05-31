package com.yedam.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter	// Setter는 필요없음
@Entity	// 도메인 = 객체
@Builder // 해당 어노테이션이 생성자를 만들어줌 따라서 생성자를 따로 만들필요가 없음
@AllArgsConstructor // 모든 인수가 있는 기본생성자
@NoArgsConstructor // 아무것도 없는 기본 생성자 생성
public class Customer { // 도메인
	
	@Id // 기본키에 대한 설정
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가, 기본키에 대한 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // 오라클은 자동 증가 기능이 없음 따라서 시퀀스를 사용해야함
	private Long id;
	private String name;
	private String phone;
	private String addr;
	
	
/*	@Builder // 생성자 위에 builder가 있으면 생성자에 있는 컬럼만 가지고 초기화해줌
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}*/
	
	
	
	
}
