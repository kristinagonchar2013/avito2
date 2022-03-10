package com.amr.project.service.datainit;

import com.amr.project.model.entity.Address;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit3 {

    private final AddressService addressService;
    private final CityService cityService;
    private final UserService userService;

    @Autowired
    public DataInit3(AddressService addressService, CityService cityService, UserService userService) {
        this.addressService = addressService;
        this.cityService = cityService;
        this.userService = userService;
    }

    @PostConstruct
    private void addressDaoInit() {
        addressService.persist(Address.builder().cityIndex("12345").city(cityService.findById(2L))
                .street("Oktyabrskaya").house("21")
                .user(userService.findById(1L)).build());
        addressService.persist(Address.builder().cityIndex("12233").city(cityService.findById(1L))
                .street("Arbat").house("1")
                .user(userService.findById(1L)).build());
        addressService.persist(Address.builder().cityIndex("09987").city(cityService.findById(3L))
                .street("Ivana Franko").house("45")
                .user(userService.findById(1L)).build());
        addressService.persist(Address.builder().cityIndex("34567").city(cityService.findById(4L))
                .street("Deribasovskaya").house("34")
                .user(userService.findById(1L)).build());
        addressService.persist(Address.builder().cityIndex("44444").city(cityService.findById(5L))
                .street("Dolce").house("76")
                .user(userService.findById(1L)).build());
        addressService.persist(Address.builder().cityIndex("55555").city(cityService.findById(6L))
                .street("Vita").house("1")
                .user(userService.findById(4L)).build());
        addressService.persist(Address.builder().cityIndex("66666").city(cityService.findById(7L))
                .street("Revolution street").house("82")
                .user(userService.findById(4L)).build());
        addressService.persist(Address.builder().cityIndex("77777").city(cityService.findById(8L))
                .street("Baker street").house("101")
                .user(userService.findById(4L)).build());
        addressService.persist(Address.builder().cityIndex("88888").city(cityService.findById(9L))
                .street("Main Street").house("1221")
                .user(userService.findById(4L)).build());
        addressService.persist(Address.builder().cityIndex("99999").city(cityService.findById(10L))
                .street("Broadway").house("2145")
                .user(userService.findById(4L)).build());
    }
}
