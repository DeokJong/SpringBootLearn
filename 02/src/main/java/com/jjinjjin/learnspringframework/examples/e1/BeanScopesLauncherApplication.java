package com.jjinjjin.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//기본적으로 Spring Framework 는 Singleton 방식 이를 바꿔주기 위해 @Scope 사용함
//싱글톤 방식일때는 오브젝트는 빈당 무조건 한개임
//프로토타입 방식일때는 오브젝트는 빈당 여러개가 될 수 있음
//같은 인스턴트를 여러번 사용할꺼면 싱글톤
//요청마다 새로운 인스턴트를 사용할꺼면 프로토타입
@Component
class NormalClass{

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication{

    public static void main(String[] args){
        try(var context =
                new AnnotationConfigApplicationContext
                        (BeanScopesLauncherApplication.class)){

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));


        }
    }
}

