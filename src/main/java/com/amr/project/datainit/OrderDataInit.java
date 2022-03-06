package com.amr.project.datainit;

import com.amr.project.dao.abstracts.AddressDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.OrderDao;
import com.amr.project.model.entity.Order;
import com.amr.project.model.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class OrderDataInit {

    private final OrderDao orderDao;
    private final ItemDao itemDao;
    private final AddressDao addressDao;

    @Autowired
    private OrderDataInit(OrderDao orderDao, ItemDao itemDao, AddressDao addressDao) {
        this.orderDao = orderDao;
        this.itemDao = itemDao;
        this.addressDao = addressDao;
    }

    @PostConstruct
    private void orderDataInit() {
        orderDao.persist(Order.builder().id(1L).items(Arrays.asList(itemDao.findById(1L), itemDao.findById(1L)))
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .address(addressDao.findById(1L)).total(BigDecimal.valueOf(301.2)).build());
        orderDao.persist(Order.builder().id(2L).items(Arrays.asList(itemDao.findById(2L), itemDao.findById(1L)))
                .date(new GregorianCalendar(2022, Calendar.JANUARY, 12)).status(Status.DELIVERED)
                .address(addressDao.findById(2L)).total(BigDecimal.valueOf(350.9)).build());
        orderDao.persist(Order.builder().id(3L).items(Arrays.asList(itemDao.findById(3L), itemDao.findById(8L)))
                .date(new GregorianCalendar(2021, Calendar.DECEMBER, 12)).status(Status.START)
                .address(addressDao.findById(3L)).total(BigDecimal.valueOf(530.6)).build());
        orderDao.persist(Order.builder().id(4L).items(Arrays.asList(itemDao.findById(4L), itemDao.findById(5L)))
                .date(new GregorianCalendar(2019, Calendar.AUGUST, 12)).status(Status.PAID)
                .address(addressDao.findById(4L)).total(BigDecimal.valueOf(376.1)).build());
        orderDao.persist(Order.builder().id(5L).items(Arrays.asList(itemDao.findById(6L), itemDao.findById(7L)))
                .date(new GregorianCalendar(2020, Calendar.SEPTEMBER, 12)).status(Status.WAITING)
                .address(addressDao.findById(5L)).total(BigDecimal.valueOf(330.5)).build());
        orderDao.persist(Order.builder().id(6L).items(Arrays.asList(itemDao.findById(8L)))
                .date(new GregorianCalendar(2018, Calendar.MARCH, 12)).status(Status.COMPLETE)
                .address(addressDao.findById(6L)).total(BigDecimal.valueOf(180)).build());
        orderDao.persist(Order.builder().id(7L).items(Arrays.asList(itemDao.findById(6L), itemDao.findById(6L), itemDao.findById(6L)))
                .date(new GregorianCalendar(2021, Calendar.MAY, 30)).status(Status.DELIVERED)
                .address(addressDao.findById(7L)).total(BigDecimal.valueOf(390)).build());
        orderDao.persist(Order.builder().id(8L).items(Arrays.asList(itemDao.findById(4L), itemDao.findById(4L)))
                .date(new GregorianCalendar(2020, Calendar.MAY, 12)).status(Status.PAID)
                .address(addressDao.findById(8L)).total(BigDecimal.valueOf(400)).build());
        orderDao.persist(Order.builder().id(9L).items(Arrays.asList(itemDao.findById(5L), itemDao.findById(1L)))
                .date(new GregorianCalendar(2021, Calendar.JULY, 12)).status(Status.WAITING)
                .address(addressDao.findById(9L)).total(BigDecimal.valueOf(301.7)).build());
        orderDao.persist(Order.builder().id(10L).items(Arrays.asList(itemDao.findById(4L), itemDao.findById(4L)))
                .date(new GregorianCalendar(2021, Calendar.NOVEMBER, 12)).status(Status.START)
                .address(addressDao.findById(10L)).total(BigDecimal.valueOf(400)).build());
        orderDao.persist(Order.builder().id(11L).items(Arrays.asList(itemDao.findById(7L), itemDao.findById(8L)))
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .address(addressDao.findById(1L)).total(BigDecimal.valueOf(380.55)).build());
    }
}
