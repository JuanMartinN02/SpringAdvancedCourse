package com.jcmn.Section9SpringAdvancedFeatures;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{

}

@Component
// ConfigurableBeanFactory.SCOPE_PROTOTYPE forces the creation of a new instance of the
// class when invoked, normally Spring could reuse the same instance of a class
// SINGLETON would have one Object instance per Spring IOC Container!
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}

@Configuration
@ComponentScan
public class PrototypeAndSingleton {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrototypeAndSingleton.class)){

            // Lets get 2 instances of a Normal Class
            // Spring will reuse the same object in the Stack for this
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // Lets get 3 instances of a Prototype Class
            // Spring will create a new instance of this Class for each get
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }
    }
}
