package com.jcmn.Section7GettingStarted;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jcmn.Section7GettingStarted")
public class GamingApp {

    public static void main(String[] args) {

        // We are now having the Spring Framework managing objects, autowiring them and creating them
        try (var context = new AnnotationConfigApplicationContext(com.jcmn.Section7GettingStarted.GamingApp.class)){

            context.getBean("superMario", Game.class).up();
            context.getBean(GameRunner.class).runGame();

        }

    }

}
