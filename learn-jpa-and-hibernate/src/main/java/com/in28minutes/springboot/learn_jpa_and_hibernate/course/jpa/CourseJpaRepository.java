package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// CRUD를 위해 메서드 정의

@Repository
@Transactional
public class CourseJpaRepository {

  @PersistenceContext // 컨테이너 관리형 EntityManager와 연결된 영속성 컨텍스트의 종속성을 주입한다. 좀 더 구체적인 어노테이션이다.
  private EntityManager entityManager;

  public void insert(Course course) {
    entityManager.merge(course);
  }

  public Course findById(long id) {
    return entityManager.find(Course.class, id);
  }

  public void deleteById(long id) {
    Course course = entityManager.find(Course.class, id);
    entityManager.remove(course);
  }
}
