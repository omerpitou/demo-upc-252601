package edu.upc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.models.Student;
import edu.upc.repositories.StudentRepo;
import edu.upc.repositories.StudentRepoCustom;

@Service
public class StudentServiceImpl implements StudentService {
	
	//@Autowired
	//private StudentRepo repo;
	
	@Autowired
	private StudentRepoCustom repoC;

	@Override
	public List<Student> get(String keyword) {
		/*
		List<Student> data = new ArrayList<>();
		data.add(new Student("Ntumba", "Katuala", "Omer"));
		data.add(new Student("Tshabu", "Kenga", "Ruth"));
		data.add(new Student("Student03", "Kenga", "Ruth"));
		*/
		// return repo.findAll();
		
		return repoC.get(keyword);
	}

}
