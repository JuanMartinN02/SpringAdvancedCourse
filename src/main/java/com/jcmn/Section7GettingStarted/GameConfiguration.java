package com.jcmn.Section7GettingStarted;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public Game superMario(){
        return new SuperMario();
    }

    @Bean
    public GameRunner gameRunner(Game superMario){
        return new GameRunner(superMario);
    }

//    var game = new SuperMario();
//    var game2 = new SuperContra();
//
//    var gameRunner = new GameRunner(game);
//
//    gameRunner.runGame();
}
