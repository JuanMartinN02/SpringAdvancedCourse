package com.jcmn.Section7GettingStarted;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GamingApp {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GameConfiguration.class);){

            context.getBean(Game.class).up();
            context.getBean(GameRunner.class).runGame();

        }

    }
}
