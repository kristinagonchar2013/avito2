package com.amr.project.datainit;

import com.amr.project.dao.abstracts.CityDao;
import com.amr.project.dao.abstracts.CountryDao;
import com.amr.project.model.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CityDataInit {

    private final CityDao cityDao;
    private final CountryDao countryDao;

    @Autowired
    public CityDataInit(CityDao cityDao, CountryDao countryDao) {
        this.cityDao = cityDao;
        this.countryDao = countryDao;
    }

    @PostConstruct
    public void cityDataInit() {
        cityDao.persist(City.builder().id(1L).name("Moscow").country(countryDao.findById(1L)).build());
        cityDao.persist(City.builder().id(2L).name("Krasnodar").country(countryDao.findById(1L)).build());
        cityDao.persist(City.builder().id(3L).name("Yekaterinburg").country(countryDao.findById(1L)).build());
        cityDao.persist(City.builder().id(4L).name("Kiev").country(countryDao.findById(2L)).build());
        cityDao.persist(City.builder().id(1L).name("Lvov").country(countryDao.findById(2L)).build());
        cityDao.persist(City.builder().id(1L).name("Odessa").country(countryDao.findById(2L)).build());
        cityDao.persist(City.builder().id(1L).name("Milan").country(countryDao.findById(3L)).build());
        cityDao.persist(City.builder().id(1L).name("Verona").country(countryDao.findById(3L)).build());
        cityDao.persist(City.builder().id(1L).name("San Remo").country(countryDao.findById(3L)).build());
        cityDao.persist(City.builder().id(1L).name("Liverpool").country(countryDao.findById(4L)).build());
        cityDao.persist(City.builder().id(1L).name("Birmingham").country(countryDao.findById(4L)).build());
        cityDao.persist(City.builder().id(1L).name("Oxford").country(countryDao.findById(4L)).build());
        cityDao.persist(City.builder().id(1L).name("Los Angeles").country(countryDao.findById(5L)).build());
        cityDao.persist(City.builder().id(1L).name("New York").country(countryDao.findById(5L)).build());
        cityDao.persist(City.builder().id(1L).name("Atlanta").country(countryDao.findById(5L)).build());
    }
}
