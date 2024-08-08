package com.in28minutes.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
class ClassA {
  public ClassA() {
    System.out.println("ClassA Initialized");
  }
}

@Component
@Lazy
class ClassB {

  private ClassA classA;

  public ClassB(ClassA classA) {
    // 여기에 복잡한 초기화 로직을 둘 수 있음.
    System.out.println("Some Initialization Logics");
    this.classA = classA;
  }

  public void doSomething() {
    System.out.println("Doing Something");
  }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
      System.out.println("Context Initialized");
      context.getBean(ClassB.class).doSomething();
    }
  }
}
