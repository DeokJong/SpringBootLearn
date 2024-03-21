package com.jjinjjin.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{}

@Component
@Lazy //기본적으로 Component는 자동으로 Bean이 생성이 되나, Lazy Annotation을 붙일 경우 사용할때 Bean이 생성된다.
class ClassB{

    private ClassA classA;
    public ClassB(ClassA classA){
        System.out.println("Some initialization logic");
        this.classA=classA;
    }

    public void doSomething(){
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication{
    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (LazyInitializationLauncherApplication.class)){

            System.out.println("Initialization of context is completed");

            context.getBean(ClassB.class).doSomething();

        }
    }
}

