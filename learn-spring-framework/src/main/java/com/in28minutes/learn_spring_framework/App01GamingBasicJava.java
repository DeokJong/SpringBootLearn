package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
        var game = new PacmanGame(); // 첫번째 객체 생성
        var gameRunner = new GameRunner(game);
        // 두 번째 객체 생성 + 종속성 연결
        gameRunner.run();
    }
}
