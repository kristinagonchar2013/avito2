package com.amr.project.datainit;

import com.amr.project.dao.abstracts.FavouriteDao;
import com.amr.project.model.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FavouriteDataInit {

    private final FavouriteDao favouriteDao;

    @Autowired
    private FavouriteDataInit(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    @PostConstruct
    private void favouriteDataInit() {
        favouriteDao.persist(Favorite.builder().id(1L).itemId(1L).build());
        favouriteDao.persist(Favorite.builder().id(2L).itemId(2L).build());
        favouriteDao.persist(Favorite.builder().id(3L).itemId(3L).build());
        favouriteDao.persist(Favorite.builder().id(4L).itemId(4L).build());
        favouriteDao.persist(Favorite.builder().id(5L).itemId(5L).build());
        favouriteDao.persist(Favorite.builder().id(6L).itemId(6L).build());
        favouriteDao.persist(Favorite.builder().id(7L).itemId(7L).build());
        favouriteDao.persist(Favorite.builder().id(8L).itemId(8L).build());
    }
}
