package com.jjinjjin.learnspringframework;

import com.jjinjjin.learnspringframework.game.GameRunner;
import com.jjinjjin.learnspringframework.game.MarioGame;
import com.jjinjjin.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        var gameRunner = new GameRunner(new MarioGame());
        gameRunner.run();

        gameRunner = new GameRunner(new SuperContraGame());
        gameRunner.run();
    }
}
