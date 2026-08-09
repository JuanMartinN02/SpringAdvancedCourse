package com.jcmn.Section8Exercise1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
interface DataService{
    int[] retrieveData();
};

@Component
@Primary
class MongoDbDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}

@Component
class MySQLDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}

@Component
class BusinessCalculation{
    public int findMax(int[] array){
        return Arrays.stream(array)
                .max()
                .orElse(0);
    }
}

@Configuration
@ComponentScan
public class BusinessCalculationService {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)){
            int[] data = context.getBean(DataService.class).retrieveData();
            System.out.println(context.getBean(BusinessCalculation.class).findMax(data));
        }
    }
}
