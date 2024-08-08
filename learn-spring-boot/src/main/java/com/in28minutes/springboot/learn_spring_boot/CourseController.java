package com.in28minutes.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CourseController {

  @RequestMapping("/coruse")
  public List<Course> retrieveAllCourses() {
    return Arrays.asList(
        new Course(1, "Learn AWS", "in28minutes"),
        new Course(2, "Learn DevOps", "in28minutes"),
        new Course(3, "Master Microservices with Spring Boot and Spring Cloud", "in28minutes"));
  }
}
