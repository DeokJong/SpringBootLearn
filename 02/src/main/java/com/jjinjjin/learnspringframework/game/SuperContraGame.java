package com.jjinjjin.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{

    @Override
    public void up() {
        System.out.println("SuperContra Up");
    }

    @Override
    public void left() {
        System.out.println("SuperContra Left");
    }

    @Override
    public void right() {
        System.out.println("SuperContra Right");
    }

    @Override
    public void down() {
        System.out.println("SuperContra Down");
    }
}
