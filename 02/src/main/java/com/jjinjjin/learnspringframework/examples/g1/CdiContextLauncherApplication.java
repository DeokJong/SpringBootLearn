package com.jjinjjin.learnspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//@Component
@Named
class BusinessService{
    private DataService dataServie;

    // @Autowired 추가시 아래 있는 Setter를 이용해서 주입을 하고 내뱉음
    public DataService getDataServie() {

        return dataServie;
    }

    //@Autowired
    @Inject
    public void setDataServie(DataService dataServie) {
        System.out.println("Setter Injection");
        this.dataServie = dataServie;
    }
}

//@Component
@Named
class DataService{

}
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (CdiContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataServie());
        }
    }
}

