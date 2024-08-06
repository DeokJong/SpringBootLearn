package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

  public static void main(String[] args) {
    try (
        var context =
        new AnnotationConfigApplicationContext
        (HelloWorldConfiguration.class)) {

      System.out.println(context.getBean("person3Qulifier"));
      System.out.println(context.getBean("primaryAddress"));
      System.out.println("\n");
      System.out.println(context.getBean(Person.class));
      System.out.println(context.getBean(Address.class));

    }
  }
}
