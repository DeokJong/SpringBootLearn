package com.jjinjjin.learnspringframework;

import com.jjinjjin.learnspringframework.game.GameRunner;
import com.jjinjjin.learnspringframework.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
