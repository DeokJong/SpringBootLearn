package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

// CRUD를 위한 쿼리문을 정의
// JdbcTemplate을 사용하여 쿼리문을 실행

@Repository
public class CourseJdbcRepository {

  @Autowired
  private JdbcTemplate springJdbcTemplate;

  private static String DELETE_QUERY = """
      delete from COURSE where id=?
      """;
  private static String INSERT_QUERY = """
      insert into COURSE(id, name, author)
      values (?, ?, ?);
      """;
  private static String SELECT_QUERY = """
      select * from COURSE
      where id=?
      """;

  public void insert(Course course) {
    springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
  }

  public void deleteById(long id) {
    springJdbcTemplate.update(DELETE_QUERY, id);
  }

  public Course findById(long id) {
    // ResultSet -> Bean => row mapper =>
    // Course 클래스를 새로 만드는 방식이기에 Setter가 필요하다. 엥 왜?
    return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    // queryForObject가 하는 방식 알아보기
  }
}
