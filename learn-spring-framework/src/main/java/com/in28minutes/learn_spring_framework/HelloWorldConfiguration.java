package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Address(String firstLine, String city) {
}

record Person(String name, int age) {
}
// 레코드 사용시 세터 게터 생성자를 만들 필요가 없다.
// 설정 클래스 밖에 있는 클래스의 인스턴스라도,
// @Bean 메서드를 통해 반환되면 스프링 컨테이너에 빈으로 등록, 관리

@Configuration // 설정 클래스 형성
public class HelloWorldConfiguration {

  @Bean
  public String name(){
    return "Ranga";
  }

  @Bean
  public int age(){
    return 15;
  }

  @Bean
  public Person person(){
    var person = new Person("Ravi", 20);
    return person;
  }

  @Bean(name = "address2") // 이름을 부여하여 빈을 등록. 디폴트는 메서드 이름
  public Address address(){
    return new Address(" Baker Street", "London");
  }

  @Bean
  public Address address2(){
    return new Address("Main Stream ", "New York");
  }

}
