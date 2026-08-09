package com.jcmn.Section4.Part1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        // 1. Launch a Spring Context (Application Context, recommended)
        var context =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. Configure the things we want Spring to manage - @Configuration
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("personita"));
        System.out.println(context.getBean("personCustom"));
        // Won't give exception because we defined of the Person beans as primary
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean("jobQualifier"));

        // We can look at all the beans for this context
        context.getBeanDefinitionNames();
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);


    }
}
