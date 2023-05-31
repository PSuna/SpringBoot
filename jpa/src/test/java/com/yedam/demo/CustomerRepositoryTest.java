package com.yedam.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // 스프링 컨텍스트 설정(빈등록) 다해줌
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository customerRepo;
	
	
	//@Test
	public void 번호검색() {
		List<Customer> list = customerRepo.findByPhone("011");
		assertEquals(list.get(0).getPhone(),"011");
	}
	
	@Test
	public void 이름검색() {
		List<Customer> list = customerRepo.findByAndSort("홍길동");
		assertEquals(list.get(0).getName(),"홍길동");
	}
	
	//@Test
	public void 고객추가() {
		
		String name = "홍길동";
		
		String phone = "011";
		Customer customer = Customer.builder().name(name).phone(phone).build(); // 객체를 생성해줌
		customerRepo.save(customer); // 기본키가 있으면 등록, 기본키가 없으면 수정임
	
		List<Customer> list = customerRepo.findAll(); // 전체조회
		System.out.println(list);
		assertEquals(list.get(0).getName(), name); // 초기에 넣은것과 같은 값이 들어가는지 비교
		
	}
	

}
