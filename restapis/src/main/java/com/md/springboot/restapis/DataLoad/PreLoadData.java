package com.md.springboot.restapis.DataLoad;

import com.md.springboot.restapis.Pojos.Persons;
import com.md.springboot.restapis.Repository.ApiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class PreLoadData {

    private static final Logger log = LoggerFactory.getLogger(PreLoadData.class);

    @Bean
    CommandLineRunner initDatabase(ApiRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Persons(5,"Bilbo"," Baggins","beach","Goa")));
            log.info("Preloading " + repository.save(new Persons(6,"Sam"," Billings","Bunglow","Odissa")));
        };
    }
}