package com.amr.project;

import com.amr.project.model.entity.Country;
import com.amr.project.service.abstracts.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication(exclude = {SessionAutoConfiguration.class,
                                  SecurityAutoConfiguration.class})
@EnableScheduling
public class ProjectApplication {
    @Autowired
    CountryService countryService;

    public static void main(String[] args){
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Scheduled(cron = "0 * * * * *")
    public void addItem() {
        countryService.persist(Country.builder().name("Russia").build());
    }
}
