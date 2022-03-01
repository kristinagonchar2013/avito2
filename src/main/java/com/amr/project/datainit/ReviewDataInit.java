package com.amr.project.datainit;

import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class ReviewDataInit {

    private final ReviewDao reviewDao;

    @Autowired
    public ReviewDataInit(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @PostConstruct
    public void reviewDataInit() {
        reviewDao.persist(Review.builder().id(1L).dignity("it's ok").date(new Date()).rating(4).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(2L).dignity("it's not ok").date(new Date()).rating(5).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(3L).dignity("ugly").date(new Date()).rating(3).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(4L).dignity("maybe").date(new Date()).rating(4).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(5L).dignity("cool").date(new Date()).rating(5).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(6L).dignity("bad").date(new Date()).rating(3).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(7L).dignity("good").date(new Date()).rating(4).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(8L).dignity("i got it").date(new Date()).rating(5).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(9L).dignity("very bad").date(new Date()).rating(2).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(10L).dignity("good staff").date(new Date()).rating(5).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(11L).dignity("normal").date(new Date()).rating(4).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(12L).dignity("sadly").date(new Date()).rating(3).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(13L).dignity("very very bad").date(new Date()).rating(2).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(14L).dignity("super").date(new Date()).rating(5).isModerated(true)
                .build());
        reviewDao.persist(Review.builder().id(15L).dignity("good").date(new Date()).rating(4).isModerated(true)
                .build());
    }
}
