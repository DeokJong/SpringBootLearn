package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // 1.Spring Context 실행
        @SuppressWarnings("resource")
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        
        // 2. Spring이 관리하기 원하는 것을 설정함 -  @Configuration, @ComponentScan, @Bean
        // HelloWolrdConfiguration - @Configuration
        // name - @Bean
        // 관리하고자 하는 항목 설정

        // 3. Spring이 관리하는 Bean을 검색
        // context.getBean을 사용하고 Bean의 이름을 부여하여 검색
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean(Address.class));
    }
}
