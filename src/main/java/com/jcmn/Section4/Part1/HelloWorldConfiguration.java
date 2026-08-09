package com.jcmn.Section4.Part1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// POJOs
record Person (String name, int age){}

record Job (Person person, String jobTittle){}

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

    @Bean
    @Qualifier("PersonaCustomQualifier") // Lets us use a different bean than the primary
    public Person personQualifier(){
        return new Person("Qualifier", 26);
    }

    // Solving the problem of having multiple beans with same POJO
    @Bean
    public Job jobQualifier(@Qualifier("PersonaCustomQualifier") Person person){
        return new Job(person, "Boss");
    }

}
