package com.yedam.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository 
	extends JpaRepository<Customer, Long>{ // 처리할 객체 타입과 기본키타입을 넘겨줘야함

	List<Customer> findByPhone(String phone); // phone에대해서 찾아줌
	
	// ?옆에는 값을 넣을 위치임
	// from 옆에는 테이블 명이 아닌 도메인명이 와야함
	// 여기서 u는 *을 뜻함
	@Query("select u from Customer u where u.name like ?1%") 
	List<Customer> findByAndSort(String name);
	
	
}
