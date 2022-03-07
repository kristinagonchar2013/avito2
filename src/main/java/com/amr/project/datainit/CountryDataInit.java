package com.amr.project.datainit;

import com.amr.project.dao.abstracts.CountryDao;
import com.amr.project.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CountryDataInit {

    private final CountryDao countryDao;

    @Autowired
    private CountryDataInit(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @PostConstruct
    private void countryDataInit() {
        countryDao.persist(Country.builder().name("Russia").build());
        countryDao.persist(Country.builder().name("Ukraine").build());
        countryDao.persist(Country.builder().name("Italy").build());
        countryDao.persist(Country.builder().name("England").build());
        countryDao.persist(Country.builder().name("USA").build());
    }
}
