package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Min(value=2)
	private String name;
	private String college;
	
	@OneToMany(mappedBy="student")
	public List<Post> post;
	
	
	 public Student(){
			
	  }
	
	
	public Student(int id, @Min(2) String name, String college, List<Post> post) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.post =  post;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public List<Post> getpost() {
		return post ;
	}


	public void setSubject(List<Post>  post) {
		this.post = post ;
	}
	 
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
	}
	
	
	
	
	
	
}
