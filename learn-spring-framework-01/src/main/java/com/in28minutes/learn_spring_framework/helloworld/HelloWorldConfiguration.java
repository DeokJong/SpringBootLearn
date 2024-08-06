package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String firstLine, String city) {
}

record Person(String name, int age, Address address) {
}
// 레코드 사용시 세터 게터 생성자를 만들 필요가 없다.
// 설정 클래스 밖에 있는 클래스의 인스턴스라도,
// @Bean 메서드를 통해 반환되면 스프링 컨테이너에 빈으로 등록, 관리

@Configuration // 설정 클래스 형성
public class HelloWorldConfiguration {

  @Bean
  public String name() {
    return "Ranga";
  }

  @Bean
  public int age() {
    return 15;
  }

  @Bean
  public Person person() {
    var person = new Person("Ravi", 20, new Address("Main  Street", "Utrecht"));
    return person;
  }

  @Bean
  public Person person2MethodCall() {
    return new Person(name(), age(), address0()); 
  }
  // Bean 매서드를 직접 호출
  // 매서드를 직접 호출할때는 빈이 아니라 일반 메서드로 호출한다.

  @Bean
  public Person person3Qulifier(String name, int age, @Qualifier("address3Qualifier") Address add) {
    return new Person(name, age, add); 
  }

  @Bean(name = "primaryPerson")
  @Primary
  public Person person4Parameters(String name, int age, Address address) {
    return new Person(name, age, address);
  }

  @Bean(name = "primaryAddress")
  @Primary
  public Address address0() {
    return new Address("Primary", "London");
  }

  @Bean(name = "address1")
  public Address address1() {
    return new Address("01", "Utrecht");
  }

  @Bean(name = "address2")
  public Address address2() {
    return new Address("02", "Utrecht");
  }

  @Bean(name = "address3") 
  @Qualifier("address3Qualifier")
  public Address address3() {
    return new Address("03", "Hyderabad");
  }

}
