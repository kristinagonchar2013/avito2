package com.amr.project.service.datainit;

import com.amr.project.model.entity.*;
import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit4 {

    private final ShopService shopService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CityService cityService;

    @Autowired
    public DataInit4(ShopService shopService, UserService userService, CategoryService categoryService, CityService cityService) {
        this.shopService = shopService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.cityService = cityService;
    }


    @PostConstruct
    private void shopDataInit() {
        shopService.persist(Shop.builder().name("Chairs & Co")
                .email("chairs.co@gmail.com").phone("11111111")
                .description("You will find what you want").rating(4.44)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .user(userService.findById(1L))
                .location(cityService.findById(1L))
                .build());

        shopService.persist(Shop.builder().name("Mr.Table")
                .email("table.and.brothers@gmail.com").phone("22222222")
                .description("It's best of the best of the best").rating(5.00)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .user(userService.findById(1L))
                .location(cityService.findById(2L))
                .build());

        shopService.persist(Shop.builder().name("Active Sport Shop")
                .email("sportforever.com").phone("333333333")
                .description("We love sport").rating(4.89)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .user(userService.findById(1L))
                .location(cityService.findById(4L))
                .build());

        shopService.persist(Shop.builder().name("Only Mobile")
                .email("worldofmobile.net").phone("444444444")
                .description("We call you!").rating(3.2)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .user(userService.findById(4L))
                .location(cityService.findById(7L))
                .build());
    }


    @PostConstruct
    private void categoryDataInit() {
        categoryService.persist(Category.builder().name("Bicycle").build());
        categoryService.persist(Category.builder().name("Smartphone").build());
        categoryService.persist(Category.builder().name("Table").build());
        categoryService.persist(Category.builder().name("Chair").build());
        categoryService.persist(Category.builder().name("Black Table").build());
        categoryService.persist(Category.builder().name("Phone").build());
        categoryService.persist(Category.builder().name("Child Staff").build());
        categoryService.persist(Category.builder().name("Adult Staff").build());
        categoryService.persist(Category.builder().name("Furniture").build());
    }
}
