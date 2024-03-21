package com.jjinjjin.learnspringframework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan //뒤에 경로를 설정해주지 않으면 현재 패키지 전체 탐색
public class DepInjectionLauncherApplication {

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (DepInjectionLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}

