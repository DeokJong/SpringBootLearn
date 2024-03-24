package com.jjinjjin.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency=someDependency;
        System.out.println("All Dependency are Ready!");
    }
    @PostConstruct//해당 Annotation 은 의존성이 주입되자마자 실행된다.
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy//컨테이너에서 인스턴트(Bean)를 삭제하는 과정에서 나오는 결과를 알려줌.
    public void cleanUp(){
        System.out.println("Clean Up");
    }
}

@Component
class SomeDependency{
    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (PrePostAnnotationsContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}

