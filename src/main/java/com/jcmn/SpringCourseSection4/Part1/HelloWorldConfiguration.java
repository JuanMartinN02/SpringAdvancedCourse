package com.jcmn.SpringCourseSection4.Part1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configure the things that we want Spring to manage (beans)
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Juan";
    }

}
