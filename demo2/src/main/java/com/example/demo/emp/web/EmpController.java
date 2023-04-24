package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	
	@Autowired EmpMapper empMapper; 
	
	@GetMapping("/")
	@ResponseBody
	public String main() {
		return "hello";
	}
	
	@GetMapping("/empList")
	public String empList(Model model){
		model.addAttribute("empList", empMapper.selectEmpAllList());
		return "empList";
	}
	
}

