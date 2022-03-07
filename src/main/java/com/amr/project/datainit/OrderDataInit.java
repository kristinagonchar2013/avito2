package com.amr.project.datainit;

import com.amr.project.dao.abstracts.AddressDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.OrderDao;
import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.Order;
import com.amr.project.model.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class OrderDataInit {

    private final OrderDao orderDao;
    private final ItemDao itemDao;
    private final AddressDao addressDao;
    private final UserDao userDao;

    @Autowired
    private OrderDataInit(OrderDao orderDao, ItemDao itemDao, AddressDao addressDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.itemDao = itemDao;
        this.addressDao = addressDao;

        this.userDao = userDao;
    }

    @PostConstruct
    private void orderDataInit() {
        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(301.2))
                .buyerName(userDao.findById(1L).getFirstName()).buyerPhone(userDao.findById(1L).getPhone())
                .items(List.of(itemDao.findById(1L), itemDao.findById(1L)))
                .address(addressDao.findById(1L))
                .user(userDao.findById(1L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2022, Calendar.JANUARY, 12)).status(Status.DELIVERED)
                .total(BigDecimal.valueOf(350.9))
                .buyerName(userDao.findById(1L).getFirstName()).buyerPhone(userDao.findById(1L).getPhone())
                .items(List.of(itemDao.findById(2L), itemDao.findById(1L)))
                .address(addressDao.findById(2L))
                .user(userDao.findById(1L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.DECEMBER, 12)).status(Status.START)
                .total(BigDecimal.valueOf(530.6))
                .buyerName(userDao.findById(2L).getFirstName()).buyerPhone(userDao.findById(2L).getPhone())
                .items(List.of(itemDao.findById(3L), itemDao.findById(8L)))
                .address(addressDao.findById(3L))
                .user(userDao.findById(2L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2019, Calendar.AUGUST, 12)).status(Status.PAID)
                .total(BigDecimal.valueOf(376.1))
                .buyerName(userDao.findById(2L).getFirstName()).buyerPhone(userDao.findById(2L).getPhone())
                .items(List.of(itemDao.findById(4L), itemDao.findById(5L)))
                .address(addressDao.findById(4L))
                .user(userDao.findById(2L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2020, Calendar.SEPTEMBER, 12)).status(Status.WAITING)
                .total(BigDecimal.valueOf(330.5))
                .buyerName(userDao.findById(2L).getFirstName()).buyerPhone(userDao.findById(2L).getPhone())
                .items(List.of(itemDao.findById(6L), itemDao.findById(7L)))
                .address(addressDao.findById(5L))
                .user(userDao.findById(2L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2018, Calendar.MARCH, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(180))
                .buyerName(userDao.findById(2L).getFirstName()).buyerPhone(userDao.findById(2L).getPhone())
                .items(List.of(itemDao.findById(8L)))
                .address(addressDao.findById(6L))
                .user(userDao.findById(2L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 30)).status(Status.DELIVERED)
                .total(BigDecimal.valueOf(390))
                .buyerName(userDao.findById(3L).getFirstName()).buyerPhone(userDao.findById(3L).getPhone())
                .items(List.of(itemDao.findById(6L), itemDao.findById(6L), itemDao.findById(6L)))
                .address(addressDao.findById(7L))
                .user(userDao.findById(3L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2020, Calendar.MAY, 12)).status(Status.PAID)
                .total(BigDecimal.valueOf(400))
                .buyerName(userDao.findById(3L).getFirstName()).buyerPhone(userDao.findById(3L).getPhone())
                .items(List.of(itemDao.findById(4L), itemDao.findById(4L)))
                .address(addressDao.findById(8L))
                .user(userDao.findById(3L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.JULY, 12)).status(Status.WAITING)
                .total(BigDecimal.valueOf(301.7))
                .buyerName(userDao.findById(3L).getFirstName()).buyerPhone(userDao.findById(3L).getPhone())
                .items(List.of(itemDao.findById(5L), itemDao.findById(1L)))
                .address(addressDao.findById(9L))
                .user(userDao.findById(3L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.NOVEMBER, 12)).status(Status.START)
                .total(BigDecimal.valueOf(400))
                .buyerName(userDao.findById(3L).getFirstName()).buyerPhone(userDao.findById(3L).getPhone())
                .items(List.of(itemDao.findById(4L), itemDao.findById(4L)))
                .address(addressDao.findById(10L))
                .user(userDao.findById(3L)).build());

        orderDao.persist(Order.builder()
                .date(new GregorianCalendar(2021, Calendar.MAY, 12)).status(Status.COMPLETE)
                .total(BigDecimal.valueOf(380.55))
                .buyerName(userDao.findById(4L).getFirstName()).buyerPhone(userDao.findById(4L).getPhone())
                .items(List.of(itemDao.findById(7L), itemDao.findById(8L)))
                .address(addressDao.findById(1L))
                .user(userDao.findById(4L)).build());
    }
}
