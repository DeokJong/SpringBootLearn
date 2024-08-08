package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalCalss{

}

@Scope(value = "prototype")
@Component
class PrototypeClass{

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

  public static void main(String[] args) {
    try (var context =
    new AnnotationConfigApplicationContext(
      BeanScopesLauncherApplication.class)) {
          System.out.println("Context Initialized");
          System.out.println("NormalCalss: " + context.getBean(NormalCalss.class));
          System.out.println("NormalCalss: " + context.getBean(NormalCalss.class));
          System.out.println("PrototypeClass: " + context.getBean(PrototypeClass.class));
          System.out.println("PrototypeClass: " + context.getBean(PrototypeClass.class));
    }
  }
}
