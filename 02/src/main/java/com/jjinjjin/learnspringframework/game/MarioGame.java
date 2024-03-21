package com.jjinjjin.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{

    @Override
    public void up() {
        System.out.println("Mario Up");
    }

    @Override
    public void left() {
        System.out.println("Mario Left");
    }

    @Override
    public void right() {
        System.out.println("Mario Right");
    }

    @Override
    public void down() {
        System.out.println("Mario Down");
    }
}
