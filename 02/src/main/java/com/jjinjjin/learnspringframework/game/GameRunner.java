package com.jjinjjin.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole gameRunner;

    public GameRunner( GamingConsole game){
        gameRunner = game;
    }
    public void run(){
        System.out.println("Game Name :" + gameRunner);
        gameRunner.up();
        gameRunner.down();
        gameRunner.right();
        gameRunner.left();
    }
}
