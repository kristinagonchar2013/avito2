package com.amr.project.service.datainit;

import com.amr.project.model.entity.City;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit2 {

    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public DataInit2(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @PostConstruct
    private void cityDataInit() {
        cityService.persist(City.builder().name("Moscow").country(countryService.findById(1L)).build());
        cityService.persist(City.builder().name("Krasnodar").country(countryService.findById(1L)).build());
        cityService.persist(City.builder().name("Kiev").country(countryService.findById(2L)).build());
        cityService.persist(City.builder().name("Odessa").country(countryService.findById(2L)).build());
        cityService.persist(City.builder().name("Milan").country(countryService.findById(3L)).build());
        cityService.persist(City.builder().name("Verona").country(countryService.findById(3L)).build());
        cityService.persist(City.builder().name("Liverpool").country(countryService.findById(4L)).build());
        cityService.persist(City.builder().name("London").country(countryService.findById(4L)).build());
        cityService.persist(City.builder().name("Los Angeles").country(countryService.findById(5L)).build());
        cityService.persist(City.builder().name("New York").country(countryService.findById(5L)).build());
    }
}
