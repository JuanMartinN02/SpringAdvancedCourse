package com.jcmn.Section9SpringAdvancedFeatures;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}

@Component
// @Lazy makes it so that the class is only initialized when called.
// Not having @Lazy makes the Bean eager, meaning it initializes on App launch,
// before being called. @Lazy is not recommended and not frequently used.
// It can cause runtime exceptions, instead of preventing the app of starting!
@Lazy
class ClassB{

    private ClassA classA;

    public ClassB() {
        System.out.println("Constructing ClassB");
        this.classA = new ClassA();
    }

    public void doSomething(){
        System.out.println("ClassB is doing something!");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationExample {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationExample.class)){
            System.out.println("**Context initialized!**");
            context.getBean(ClassB.class).doSomething();
        }
    }
}
