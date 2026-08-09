package com.jcmn.Section9SpringAdvancedFeatures;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("SomeClass Constructed!");
    }

    // @PostConstruct executes the method after the construction of the class!
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    // @PreDestroy Executes before application is terminated (before bean is destroyed!)
    @PreDestroy
    public void cleanup(){
        System.out.println("Cleanup code on SomeClass!");
    }

}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("SomeDependency is ready!");
    }
}

@Configuration
@ComponentScan
public class PostConstructAndPreDestroy {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PostConstructAndPreDestroy.class)){
            System.out.println("Context Initialized!");
        }
    }
}
