package com.amr.project.service.datainit;

import com.amr.project.model.entity.Country;
import com.amr.project.model.entity.User;
import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class DataInit1 {

    private final CountryService countryService;
    private final UserService userService;

    @Autowired
    public DataInit1(CountryService countryService, UserService userService) {
        this.countryService = countryService;
        this.userService = userService;
    }

    @PostConstruct
    private void countryDataInit() {
        countryService.persist(Country.builder().name("Russia").build());
        countryService.persist(Country.builder().name("Ukraine").build());
        countryService.persist(Country.builder().name("Italy").build());
        countryService.persist(Country.builder().name("England").build());
        countryService.persist(Country.builder().name("USA").build());
    }


    @PostConstruct
    private void userDataInit() {
        userService.persist(User.builder().email("user@init.com")
                .username("user").password("user")
                .activate(true).activationCode("user")
                .phone("1111111").firstName("user").lastName("user").age(30).gender(Gender.MALE)
                .role(Role.USER)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());

        userService.persist(User.builder().email("admin@init.com")
                .username("admin").password("admin")
                .activate(true).activationCode("admin")
                .phone("1111111").firstName("admin").lastName("admin").age(30).gender(Gender.MALE)
                .role(Role.ADMIN)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());

        userService.persist(User.builder().email("moderator@init.com")
                .username("moderator").password("moderator")
                .activate(true).activationCode("moderator")
                .phone("1111111").firstName("moderator").lastName("moderator").age(30).gender(Gender.MALE)
                .role(Role.MODERATOR)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());

        userService.persist(User.builder().email("user1@init.com")
                .username("user1").password("user1")
                .activate(true).activationCode("user1")
                .phone("1111111").firstName("user1").lastName("user1").age(30).gender(Gender.MALE)
                .role(Role.USER)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());

        userService.persist(User.builder().email("user2@init.com")
                .username("user2").password("user2")
                .activate(true).activationCode("user2")
                .phone("1111111").firstName("user2").lastName("user2").age(30).gender(Gender.MALE)
                .role(Role.USER)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());

        userService.persist(User.builder().email("user3@init.com")
                .username("user3").password("user3")
                .activate(true).activationCode("user3")
                .phone("1111111").firstName("user3").lastName("user3").age(30).gender(Gender.MALE)
                .role(Role.USER)
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());
    }
}
