package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

//Spring 어플리케이션이 시작될 때 실행되는 클래스
@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner{

  @Autowired
  private CourseSpringDataJPARepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Course(1, "learn AWS JPA!", "in28minutes"));
    repository.save(new Course(2, "learn AZURE JPA!", "Jin"));
    repository.save(new Course(3, "learn DevOps JPA!", "Mary"));

    repository.deleteById(1l);

    System.out.println(repository.findById(2l));
    System.out.println(repository.findById(3l));

    System.out.println(repository.findByAuthor("in28minutes"));
    System.out.println(repository.findByAuthor(""));

    System.out.println(repository.findByName("learn DevOps JPA!"));
  }
  
}
