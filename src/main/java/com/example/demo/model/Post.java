package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private int sub_id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
	public Student student;
	
	public Post(int sub_id, String name, Student student) {
		super();
		this.sub_id = sub_id;
		this.name = name;
		this.student = student;
	}
	public Post() {
		
	}
	
	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Subject [sub_id=" + sub_id + ", name=" + name + "]";
	}
}
