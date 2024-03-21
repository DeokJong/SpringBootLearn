package com.jjinjjin.learnspringframework.examples.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication{

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (BeanScopesLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}

