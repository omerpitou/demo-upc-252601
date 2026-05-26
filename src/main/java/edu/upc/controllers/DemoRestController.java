package edu.upc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.upc.models.Student;
import edu.upc.services.StudentService;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

	@Autowired
	private StudentService service;

	@GetMapping("/get/name")
	public List<Student> getMyName(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		return service.get(keyword);
	}

}
