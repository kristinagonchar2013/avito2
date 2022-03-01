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
    public CountryDataInit(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @PostConstruct
    public void countryDataInit() {
        countryDao.persist(Country.builder().id(1L).name("Russia").build());
        countryDao.persist(Country.builder().id(2L).name("Ukraine").build());
        countryDao.persist(Country.builder().id(3L).name("Italy").build());
        countryDao.persist(Country.builder().id(4L).name("England").build());
        countryDao.persist(Country.builder().id(5L).name("USA").build());
    }
}
