package com.jjinjjin.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age,Address address){}
record Address(String firstLine, String code){}
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "deok-jong";
    }
    @Bean
    public int age(){
        return 26;
    }
    @Bean
    public Person person(){
        return new Person("deok-jong",26, new Address("Main Steet", "12345"));
    }

    @Bean(name = "address2")
    public Address address2(){
        return new Address("Jeon-ju","55380");
    }

    @Bean
    @Primary
    public Address address3(){
        return new Address("Dae-jeon","99999");
    }


    @Bean
    public Address address(){
        return new Address("Main-Gu","77777");
    }


    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }

    @Bean
    public Person person3Parameter(String name, int age, Address address){
        return new Person(name,age,address);
    }

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("address4Qualifier") Address address){
        return new Person(name,age,address);
    }

    @Bean
    @Qualifier("address4Qualifier")
    public Address address4(){
        return new Address("Dae-jeon","88888");
    }
}
