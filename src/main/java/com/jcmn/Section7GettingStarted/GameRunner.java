package com.jcmn.Section7GettingStarted;

public class GameRunner {
    private Game game;

    public GameRunner(Game game) {
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
