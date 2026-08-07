package com.jcmn.Section7GettingStarted;

public class Game{
    private String console;
    private String name;

    public Game(String console, String name) {
        this.console = console;
        this.name = name;
    }

    public void up(){
        System.out.println("Going up!");
    };

    public void down(){
        System.out.println("Going down!");
    };

    public void left(){
        System.out.println("Going left!");
    };

    public void right(){
        System.out.println("Going right!");
    };

    public String getName() {
        return name;
    }

    public String getConsole() {
        return console;
    }
}
