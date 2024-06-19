package com.example.edu.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edu.entity.Course;
import com.example.edu.service.CourseService;

@RestController
@RequestMapping("/course/v1")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/")
	public Course createCourse(@RequestBody Course course) {
		return this.courseService.createCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public Map<String,Object> removeCourse(@PathVariable Long id){
		
		return courseService.deleteCourse(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Course> retrieveCourse(@PathVariable Long id) {
		return this.courseService.retrieveCourse(id);
	}
	
	@PutMapping("/{id}")
	public Map<String,Object> updateCourse(@PathVariable Long id,@RequestBody Course course){
		
		return courseService.updateCourse(id,course);
	}
	
	

}
