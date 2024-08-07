package com.in28minutes.learn_spring_framework.game;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GamingAppLauncherApplication {

  public static void main(String[] args) {
    try (var context =
    new AnnotationConfigApplicationContext(
      GamingAppLauncherApplication.class)) {
      context.getBean(GamingConsole.class).up();
      context.getBean(GameRunner.class).run();

      Arrays.stream(context.getBeanDefinitionNames())
        .forEach(System.out::println);
    }
  }
}
