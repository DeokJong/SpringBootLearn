package com.jjinjjin.learnspringframework.examples.a0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/*
* YourBusinessClass
*   Dependency1
*   Dependency2
*
* 생성자 주입, 수정자 주입, 필드 주입을 이용해 두 Dependency를 YourBusinessClass에 주입
* */

@Component
class YourBusinessClass{

    //필드 주입 예시
    @Autowired
    Dependency1 dependency1;
    Dependency2 dependency2;
    Dependency3 dependency3;

    //생성자 주입 예시
    @Autowired//생성자 주입시 Autowired가 필수가 아님.
    //가장 추천하는 주입 기법
    // 모든 초기화가 하나의 메소드에서 발생하기에 가장 추천하는 주입기법임
    public YourBusinessClass(Dependency3 dependency3) {
        System.out.println("Constructor Injection - set dependency3");
        this.dependency3 = dependency3;
    }

    //수정자 주입 예시
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - set dependency2");
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using "+dependency1+" and "+dependency2;
    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Component
class Dependency3{

}

@Configuration
@ComponentScan //뒤에 경로를 설정해주지 않으면 현재 패키지 전체 탐색
public class SimpleSpringContextLauncherApplication {

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (SimpleSpringContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));

        }
    }
}

