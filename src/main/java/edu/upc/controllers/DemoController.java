package edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.upc.services.StudentService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/get/name")
	public String getMyName(@RequestParam(value="keyword", required=false) String keyword, Model model) {
		
		model.addAttribute("myKeyword", keyword);
		model.addAttribute("myStudents", service.get(keyword));
		
		return "index";
	}
	
	/*
	@GetMapping("/get/name")
	public String getMyName2(@RequestParam("keyword") String keyword) {
		return "index";
	}*/

}
