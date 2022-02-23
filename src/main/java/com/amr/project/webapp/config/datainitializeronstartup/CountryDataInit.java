package com.amr.project.webapp.config.datainitializeronstartup;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CountryDataInit {

    private final ReadWriteDao<Country, Long> countryReadWriteDao;

    @Autowired
    public CountryDataInit(ReadWriteDao<Country, Long> countryReadWriteDao) {
        this.countryReadWriteDao = countryReadWriteDao;
    }

    @PostConstruct
    public void countryDataInit() {
        countryReadWriteDao.persist(Country.builder().id(1L).name("Russia").build());
        countryReadWriteDao.persist(Country.builder().id(2L).name("Ukraine").build());
        countryReadWriteDao.persist(Country.builder().id(3L).name("Italy").build());
        countryReadWriteDao.persist(Country.builder().id(4L).name("England").build());
        countryReadWriteDao.persist(Country.builder().id(5L).name("USA").build());
    }
}
