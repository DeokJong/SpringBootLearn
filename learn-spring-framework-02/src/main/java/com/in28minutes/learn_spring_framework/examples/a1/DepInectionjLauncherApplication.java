package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface DepInterface {}

@Component
class Dependency1 implements DepInterface {}

@Component
class Dependency2 implements DepInterface {}

@Component
class MainClass {
  DepInterface dependency;

  public MainClass(DepInterface dependency) {
    this.dependency = dependency;
  }

  public String toString() {
    return "YourBusinessClass [dependency=" + dependency + "]";
  }
}

@Configuration
@ComponentScan
class ConfigClass {}

public class DepInectionjLauncherApplication {

  public static void main(String[] args) {
    try (var context =
    new AnnotationConfigApplicationContext(
      ConfigClass.class)) {

        System.out.println(context.getBean(MainClass.class).toString());
    }
  }
}
