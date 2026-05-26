package edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.upc.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	// List<Student> get();

}
