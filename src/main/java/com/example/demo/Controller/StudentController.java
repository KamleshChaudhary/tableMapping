package com.example.demo.Controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.StudentService;
import com.example.demo.model.*;
@RestController
@RequestMapping("Student")
public class StudentController {
	
    @Autowired	
    StudentService studentservice;	
	
	@GetMapping("/all")
	public List<Student> getAllstudent() {
		
		return studentservice.list2();
	}
	
	@GetMapping("/all/{id}")
	public org.springframework.hateoas.Resource<Student> studentsid(@PathVariable int id) {	
		
		Student student= studentservice.studentfinding(id);
        
       org.springframework.hateoas.Resource<Student> resource= new org.springframework.hateoas.Resource<Student>(student);
		
		ControllerLinkBuilder linkTo=linkTo((methodOn(this.getClass())).getAllstudent());
		
		resource.add(linkTo.withRel("all-student"));
		return resource;	
	}
	
	@PostMapping("/all")
	public ResponseEntity<Object> studentpost(@Valid @RequestBody Student student)
	{
		studentservice.addstudent(student);
		
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(student.getId()).toUri();
		
	    return	ResponseEntity.created(location).build();
	}
	
	@PutMapping("/all/{id}")
	public void updateStudent(@PathVariable int id,@RequestBody Student student)
	{
		studentservice.updatestudent(id,student);
	}
	
	@DeleteMapping("/all/{id}")
	public void deleteid(@PathVariable int id)
	{
	    studentservice.deletestudent(id);
	}
	
	@GetMapping("/all/{id}/posts")
	public Optional<Student> getAllstudent(@PathVariable int id) {
		
		return studentservice.list(id);
	}

}
