package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class HomeController {
	
		
		@Autowired
		StudentRepository studentRepository;
		
		@GetMapping("/")
		public String index()
		{
			return "Welcome to spring boot application!!!";
		}
		
		@PostMapping("/saveStudent")
		public Student save(@RequestBody Student st)
		{
			studentRepository.save(st);
			return st;
		}
		
		@GetMapping("/getAll")
		public List<Student> getAll()
		{
			List<Student> crudList=studentRepository.findAll();
			return crudList;
		}
		
		@DeleteMapping("/delete/{rollNo}")
		public String delete(@PathVariable int rollNo)
		{
			Student crud=studentRepository.findById(rollNo).get();
			if(crud!=null)
			{
				studentRepository.delete(crud);
			}
			return "Deleted successfully";
		}
		
		@PutMapping("/update")
		public Student update(@RequestBody Student st)
		{
			studentRepository.save(st);
			return st;
		}
	

}
