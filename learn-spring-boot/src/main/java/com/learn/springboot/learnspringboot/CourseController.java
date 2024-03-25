package com.learn.springboot.learnspringboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class CourseController{
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourse(){
		return Arrays.asList(
				new Course(1, "Learn AWS","in28min"),
				new Course(2, "Learn AWS","in28min")
		);
	}
}
