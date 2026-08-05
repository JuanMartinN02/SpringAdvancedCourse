package com.jcmn.SpringCourseSection4.Part1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age){}

// Configure the things that we want Spring to manage (beans)
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Juan";
    }

    @Bean
    public int age(){
        return 20;
    }

    @Bean
    public Person person(){
        var person = new Person(name(), age());
        return person;
    }

}
