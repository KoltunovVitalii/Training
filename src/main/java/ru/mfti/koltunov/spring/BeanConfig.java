package ru.mfti.koltunov.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;


@Configuration
public class BeanConfig {
    List<Integer> integerList = new ArrayList<>();
    @Bean
    String hello() {
        return "Hello world";
    }

    @Bean
    @Scope("prototype")
    @Qualifier("random")
    int random(int min, int max) {
        int result = ThreadLocalRandom.current().nextInt(min, max);

        while (integerList.size() < max - min && integerList.contains(result)) {
            result = ThreadLocalRandom.current().nextInt(min, max);
        }
        integerList.add(result);
        return result;
    }

    @Bean
    @Lazy
    Date firstData() {
        return new Date();
    }

    @Bean
    Predicate<Integer> from2To5(){
        return i -> i >= 2 && i <= 5;
    }

    @Bean
    @Scope("prototype")
    Student student(Student.StudentFactory studentFactory){
        return studentFactory.getStudent("Vasya");
    }

    @Bean
    int min() {
        return 0;
    }

    @Bean
    int max() {
        return 100;
    }

    @Bean
    Review rewiew1(){
        return new Review("Очень хорошо", 4);
    }

    @Bean
    Review rewiew2(){
        return new Review("Сойдет", 3);
    }

    @Bean
    @Qualifier("random")
    Review rewiew3(){
        return new Review("Сложно сказать", random(1, 4));
    }
    @Bean
    @Scope("prototype")
    Review bestReview(List<Review> reviewList) {
        return reviewList.stream()
                .max((x, y) -> x.getRating() - y.getRating())
                .orElse(null);
    }
}


