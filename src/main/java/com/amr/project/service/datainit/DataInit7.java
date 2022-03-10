package com.amr.project.service.datainit;

import com.amr.project.model.entity.Review;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ReviewService;
import com.amr.project.service.abstracts.ShopService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class DataInit7 {

    private final ReviewService reviewService;
    private final ItemService itemService;
    private final UserService userService;
    private final ShopService shopService;

    @Autowired
    public DataInit7(ReviewService reviewService, ItemService itemService, UserService userService, ShopService shopService) {
        this.reviewService = reviewService;
        this.itemService = itemService;
        this.userService = userService;
        this.shopService = shopService;
    }

    @PostConstruct
    private void reviewDataInit() {
        reviewService.persist(Review.builder().dignity("it's ok").flaw("Too simple").text("i like this")
                .date(new Date()).rating(4).isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(1L))
                .user(userService.findById(1L))
                .build());
        reviewService.persist(Review.builder().dignity("it's not ok").flaw("don't like")
                .date(new Date()).rating(5).text("don't like this")
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(2L))
                .user(userService.findById(1L))
                .build());
        reviewService.persist(Review.builder().dignity("ugly").flaw("all").date(new Date()).rating(2)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(2L))
                .user(userService.findById(1L))
                .build());
        reviewService.persist(Review.builder().dignity("maybe").flaw("maybe").date(new Date()).rating(4)
                .text("never buy it").isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(3L))
                .user(userService.findById(1L))
                .build());
        reviewService.persist(Review.builder().dignity("cool").flaw("no").date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(4L))
                .user(userService.findById(1L))
                .build());
        reviewService.persist(Review.builder().dignity("bad").flaw("very bad").date(new Date()).rating(3)
                .text("i'll never buy it one more time").isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(6L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("good").flaw("no").date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(6L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("i got it").flaw("no").date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemService.findById(8L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("very bad").flaw("it all").date(new Date()).rating(2)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopService.findById(2L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("good staff").flaw("no").date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopService.findById(3L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("normal").flaw("its simple").date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopService.findById(3L))
                .user(userService.findById(4L))
                .build());
        reviewService.persist(Review.builder().dignity("no").flaw("sadly").date(new Date()).rating(3)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopService.findById(4L))
                .user(userService.findById(4L))
                .build());
    }
}
