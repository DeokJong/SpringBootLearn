package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{
  // interface만 만들어도 JpaRepository를 상속받으면 기본적인 CRUD 메소드를 사용할 수 있다.
  // 여기에 특별한 메소드를 추가하면 해당 메소드를 사용할 수 있다.

  List<Course> findByAuthor(String author);

  List<Course> findByName(String name);

  // 내가 특별히 정의 안해도 작동하는 이유 찾아보기
}