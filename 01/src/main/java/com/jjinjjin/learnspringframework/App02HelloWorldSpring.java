package com.jjinjjin.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (HelloWorldConfiguration.class);

        System.out.println(context.getBean("helloWorldConfiguration"));
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameter"));
        System.out.println(context.getBean("person4Qualifier"));
        System.out.println(context.getBean(Address.class));
    }
}
