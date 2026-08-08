package com.jcmn.Section7GettingStarted;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private Game game;

    public GameRunner(@Qualifier("SuperMarioGameQualifier") Game game) {
        this.game = game;
    }

    public void runGame(){
        System.out.println(this.game.getName() + " Is running on " + this.game.getConsole());
        game.up();
        game.right();
        game.left();
        game.down();
    }
}
