package com.jcmn.Section8SpringToManageJavaObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {
    // Field injection
    // @Autowired
    Dependency1 dependency1;

    // Field injection
    // @Autowired
    Dependency2 dependency2;

    // Constructor injection **RECOMMENDED**
    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("**Constructor injection**");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }

    // Setter injection
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("**Setter injection - setDependency1**");
//        this.dependency1 = dependency1;
//    }

    // Setter injection
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("**Setter injection - setDependency2**");
//        this.dependency2 = dependency2;
//    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class DepInjectionLauncherApp {

    public static void main(String[] args) {

        // We are now having the Spring Framework managing objects, autowiring them and creating them
        try (var context = new AnnotationConfigApplicationContext(com.jcmn.Section8SpringToManageJavaObjects.DepInjectionLauncherApp.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class).toString());

        }

    }

}
