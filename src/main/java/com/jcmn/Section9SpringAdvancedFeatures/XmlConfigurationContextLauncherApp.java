package com.jcmn.Section9SpringAdvancedFeatures;

import com.jcmn.Section8SpringToManageJavaObjects.YourBusinessClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class XmlConfigurationContextLauncherApp {

    public static void main(String[] args) {

        // We are now having the Spring Framework managing objects, autowiring them and creating them
        try (var context = new ClassPathXmlApplicationContext(XmlConfigurationContextLauncherApp.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }

}
