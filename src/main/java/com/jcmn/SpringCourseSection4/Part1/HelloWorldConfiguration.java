package com.jcmn.SpringCourseSection4.Part1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// POJOs
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

    @Bean(name = "personita")
    @Primary // Makes it the primary bean for Person Class
    public Person person(){
        var person = new Person(name(), age());
        return person;
    }

    @Bean
    public Person personCustom(String name, int age){ // Finds beans with matching names and wires the dependencies
        return new Person(name, age);
    }

}
