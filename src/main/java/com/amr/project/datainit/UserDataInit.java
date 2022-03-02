package com.amr.project.datainit;

import com.amr.project.dao.abstracts.*;
import com.amr.project.model.entity.User;
import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class UserDataInit {

    private final UserDao userDao;
    private final AddressDao addressDao;
    private final OrderDao orderDao;
    private final ShopDao shopDao;
    private final DiscountDao discountDao;
    private final FavouriteDao favouriteDao;

    @Autowired
    public UserDataInit(UserDao userDao, AddressDao addressDao, OrderDao orderDao, ShopDao shopDao, DiscountDao discountDao, FavouriteDao favouriteDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
        this.orderDao = orderDao;
        this.shopDao = shopDao;
        this.discountDao = discountDao;
        this.favouriteDao = favouriteDao;
    }

    @PostConstruct
    private void userDataInit() {
        userDao.persist(User.builder().id(1L).email("user@init.com").username("user").password("user").activate(true)
                .activationCode("user").phone("1111111").firstName("user").lastName("user").age(30).gender(Gender.MALE)
                .address(Arrays.asList(addressDao.findById(1L), addressDao.findById(2L)))
                .roles(Arrays.asList(Role.USER)).birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .orders(Arrays.asList(orderDao.findById(1L), orderDao.findById(2L))).favorite(favouriteDao.findById(5L))
                .discounts(Arrays.asList(discountDao.findById(1L), discountDao.findById(4L))).build());
        userDao.persist(User.builder().id(2L).email("admin@init.com").username("admin").password("admin").activate(true)
                .activationCode("admin").phone("1111111").firstName("admin").lastName("admin").age(30).gender(Gender.MALE)
                .roles(Arrays.asList(Role.ADMINISTRATOR)).birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .shops(Arrays.asList(shopDao.findById(1L))).build());
        userDao.persist(User.builder().id(3L).email("moderator@init.com").username("moderator").password("moderator")
                .activate(true).activationCode("moderator").phone("1111111").firstName("moderator").lastName("moderator")
                .age(30).gender(Gender.MALE).roles(Arrays.asList(Role.MODERATOR))
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .build());
        userDao.persist(User.builder().id(4L).email("user1@init.com").username("user1").password("user1").activate(true)
                .activationCode("user1").phone("1111111").firstName("user1").lastName("user1").age(30).gender(Gender.MALE)
                .address(Arrays.asList(addressDao.findById(3L), addressDao.findById(4L)))
                .roles(Arrays.asList(Role.USER, Role.ADMINISTRATOR))
                .birthday(new GregorianCalendar(1991, Calendar.MAY, 9))
                .orders(Arrays.asList(orderDao.findById(3L), orderDao.findById(4L))).favorite(favouriteDao.findById(1L))
                .shops(Arrays.asList(shopDao.findById(2L), shopDao.findById(3L)))
                .discounts(Arrays.asList(discountDao.findById(3L), discountDao.findById(4L))).build());
    }
}