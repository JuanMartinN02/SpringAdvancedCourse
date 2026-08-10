package com.jcmn.Section9SpringAdvancedFeatures;

import com.jcmn.Section7GettingStarted.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


// ALMOST NEVER USE IN THE PRESENT, NOW WE USE ANNOTATIONS LIKE THE ONES WE'VE SEEN.
// XML CONFIGS CAN BE SEEN IN LEGACY CODE
public class XmlConfigurationContextLauncherApp {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            context.getBean(GameRunner.class).runGame();
        }

    }

}