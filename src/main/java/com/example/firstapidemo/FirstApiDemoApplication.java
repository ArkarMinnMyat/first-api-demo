package com.example.firstapidemo;

import com.example.firstapidemo.dao.StudentDao;
import com.example.firstapidemo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class FirstApiDemoApplication {

    private final StudentDao studentDao;
    @Bean
    @Transactional
    public ApplicationRunner runner(){
        return runner -> {
            List.of(
                    new Student("Mg","mg","mg@gmail.com","KBTC"),
                    new Student("Ko","mg","ko@gmail.com","KBTC"),
                    new Student("Aung","Aung","aung@gmail.com","KBTC"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstApiDemoApplication.class, args);
    }

}
