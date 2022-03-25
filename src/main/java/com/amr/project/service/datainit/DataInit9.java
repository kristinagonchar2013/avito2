package com.amr.project.service.datainit;

import com.amr.project.model.entity.Order;
import com.amr.project.model.enums.Status;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class DataInit9 {

    private final ItemService itemService;
    private final UserService userService;
    private final OrderService orderService;
    private final AddressService addressService;

    @Autowired
    public DataInit9(ItemService itemService, UserService userService, OrderService orderService, AddressService addressService) {
        this.itemService = itemService;
        this.userService = userService;
        this.orderService = orderService;
        this.addressService = addressService;
    }

   @PostConstruct
    private void orderDataInit() {
        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(301.2))
                .item(itemService.findById(1L))
                .item(itemService.findById(4L))
                .address(addressService.findById(1L))
                .user(userService.findById(1L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2022, Calendar.JANUARY, 12)).status(Status.DELIVERED)
                .total(BigDecimal.valueOf(350.9))
                .item(itemService.findById(2L))
                .item(itemService.findById(1L))
                .address(addressService.findById(2L))
                .user(userService.findById(1L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.DECEMBER, 12)).status(Status.START)
                .total(BigDecimal.valueOf(530.6))
                .item(itemService.findById(3L))
                .item(itemService.findById(8L))
                .address(addressService.findById(3L))
                .user(userService.findById(2L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2019, Calendar.AUGUST, 12)).status(Status.PAID)
                .total(BigDecimal.valueOf(376.1))
                .item(itemService.findById(4L))
                .item(itemService.findById(5L))
                .address(addressService.findById(4L))
                .user(userService.findById(2L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2020, Calendar.SEPTEMBER, 12)).status(Status.WAITING)
                .total(BigDecimal.valueOf(330.5))
                .item(itemService.findById(6L))
                .item(itemService.findById(7L))
                .address(addressService.findById(5L))
                .user(userService.findById(2L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2018, Calendar.MARCH, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(180))
                .item(itemService.findById(8L))
                .address(addressService.findById(6L))
                .user(userService.findById(2L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 30)).status(Status.DELIVERED)
                .total(BigDecimal.valueOf(390))
                .item(itemService.findById(6L))
                .item(itemService.findById(6L))
                .item(itemService.findById(6L))
                .address(addressService.findById(7L))
                .user(userService.findById(3L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2020, Calendar.MAY, 12)).status(Status.PAID)
                .total(BigDecimal.valueOf(400))
                .item(itemService.findById(4L))
                .item(itemService.findById(4L))
                .address(addressService.findById(8L))
                .user(userService.findById(3L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.JULY, 12)).status(Status.WAITING)
                .total(BigDecimal.valueOf(301.7))
                .item(itemService.findById(5L))
                .item(itemService.findById(1L))
                .address(addressService.findById(9L))
                .user(userService.findById(3L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.NOVEMBER, 12)).status(Status.START)
                .total(BigDecimal.valueOf(400))
                .item(itemService.findById(4L))
                .item(itemService.findById(4L))
                .address(addressService.findById(10L))
                .user(userService.findById(3L))
                .build());

        orderService.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(380.55))
                .item(itemService.findById(7L))
                .item(itemService.findById(8L))
                .address(addressService.findById(1L))
                .user(userService.findById(4L))
                .build());
    }
}
