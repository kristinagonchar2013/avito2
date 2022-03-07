package com.amr.project.datainit;

import com.amr.project.dao.abstracts.AddressDao;
import com.amr.project.dao.abstracts.CityDao;
import com.amr.project.model.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AddressDataInit {

    private final AddressDao addressDao;
    private final CityDao cityDao;

    @Autowired
    private AddressDataInit(AddressDao addressDao, CityDao cityDao) {
        this.addressDao = addressDao;
        this.cityDao = cityDao;
    }

    @PostConstruct
    private void addressDaoInit() {
        addressDao.persist(Address.builder()
                .cityIndex("12345").city(cityDao.findById(2L))
                .street("Oktyabrskaya").house("21").build());

        addressDao.persist(Address.builder()
                .cityIndex("12233").city(cityDao.findById(1L))
                .street("Arbat").house("1").build());

        addressDao.persist(Address.builder()
                .cityIndex("09987").city(cityDao.findById(3L))
                .street("Ivana Franko").house("45").build());

        addressDao.persist(Address.builder()
                .cityIndex("34567").city(cityDao.findById(4L))
                .street("Deribasovskaya").house("34").build());

        addressDao.persist(Address.builder()
                .cityIndex("44444").city(cityDao.findById(5L))
                .street("Dolce").house("76").build());

        addressDao.persist(Address.builder()
                .cityIndex("55555").city(cityDao.findById(6L))
                .street("Vita").house("1").build());

        addressDao.persist(Address.builder()
                .cityIndex("66666").city(cityDao.findById(7L))
                .street("Revolution street").house("82").build());

        addressDao.persist(Address.builder()
                .cityIndex("77777").city(cityDao.findById(8L))
                .street("Baker street").house("101").build());

        addressDao.persist(Address.builder()
                .cityIndex("88888").city(cityDao.findById(9L))
                .street("Main Street").house("1221").build());

        addressDao.persist(Address.builder()
                .cityIndex("99999").city(cityDao.findById(10L))
                .street("Broadway").house("2145").build());
    }
}
