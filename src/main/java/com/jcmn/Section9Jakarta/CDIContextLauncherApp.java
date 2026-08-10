package com.jcmn.Section9Jakarta;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Named // Jakarta @Component
class DataService{

}

//@Component
@Named // Jakarta @Component
class BusinessService{
    private DataService dataService;

    // @Autowired
    @Inject // Jakarta @Autowired
    public BusinessService(DataService dataService) {
        System.out.println("**Constructor injection**");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}

@Configuration
@ComponentScan
public class CDIContextLauncherApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncherApp.class)){
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
