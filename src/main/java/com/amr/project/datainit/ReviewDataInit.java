package com.amr.project.datainit;

import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class ReviewDataInit {

    private final ReviewDao reviewDao;
    private final ItemDao itemDao;
    private final ShopDao shopDao;
    private final UserDao userDao;

    @Autowired
    private ReviewDataInit(ReviewDao reviewDao, ItemDao itemDao, ShopDao shopDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.itemDao = itemDao;
        this.shopDao = shopDao;
        this.userDao = userDao;
    }

    @PostConstruct
    private void reviewDataInit() {
        reviewDao.persist(Review.builder()
                .dignity("it's ok").flaw("Too simple")
                .text("i like this")
                .date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(1L))
                .user(userDao.findById(1L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("it's not ok").flaw("don't like")
                .date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(2L))
                .user(userDao.findById(1L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("ugly").flaw("all")
                .date(new Date()).rating(2)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(3L))
                .user(userDao.findById(1L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("maybe").flaw("maybe")
                .date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(4L))
                .user(userDao.findById(2L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("cool").flaw("no")
                .date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopDao.findById(1L))
                .user(userDao.findById(3L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("bad").flaw("very bad")
                .date(new Date()).rating(3)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(5L))
                .user(userDao.findById(4L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("good").flaw("no")
                .date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(5L))
                .user(userDao.findById(1L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("i got it").flaw("no")
                .date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(7L))
                .user(userDao.findById(2L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("very bad").flaw("it all")
                .date(new Date()).rating(2)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopDao.findById(2L))
                .user(userDao.findById(3L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("good staff").flaw("no")
                .date(new Date()).rating(5)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .item(itemDao.findById(7L))
                .user(userDao.findById(4L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("normal").flaw("its simple")
                .date(new Date()).rating(4)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopDao.findById(1L))
                .user(userDao.findById(1L))
                .build());

        reviewDao.persist(Review.builder()
                .dignity("no").flaw("sadly")
                .date(new Date()).rating(3)
                .isModerateAccept(true).moderatedRejectReason("adding")
                .shop(shopDao.findById(4L))
                .user(userDao.findById(4L))
                .build());
    }
}
