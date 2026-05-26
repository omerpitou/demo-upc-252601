package edu.upc.repositories;

import java.util.List;

import edu.upc.models.Student;

public interface StudentRepoCustom {
	
	List<Student> get(String keyword);

}
