package com.web.searchservice;

import com.web.searchservice.model.TestModel;
import com.web.searchservice.repository.TestModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }


    @Bean
    String stringqwd(@Autowired TestModelRepository testModelRepository) {

        testModelRepository.save(new TestModel().setId(1L).setName("tesssttt"));
        System.out.println("-----------------------------------------------");
        testModelRepository.findAll().forEach(testModel -> {
            System.out.println(testModel.getId());
        });
        System.out.println("-----------------------------------------------");
        return "";
    }


}
