package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

@Service
public class StudentService {
	 
	@Autowired
	StudentDTO studentdto;
	
			
	public  Optional<Student> list(int id){
		return studentdto.findById(id);			
	}
	public  List<Student> list2(){
		return studentdto.findAll();			
	}

	public  Student studentfinding(int id) {
		return studentdto.findById(id).get();
	}

	public void addstudent(Student student) {
			studentdto.save(student);
	}

	public void updatestudent(int id, Student student) {
		
	studentdto.save(student);
		
    }

	public void deletestudent(int id) {
		
		studentdto.deleteById(id);
	}
		
	
}
