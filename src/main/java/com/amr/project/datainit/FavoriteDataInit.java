package com.amr.project.datainit;

import com.amr.project.dao.abstracts.FavoriteDao;
import com.amr.project.model.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FavoriteDataInit {

    private final FavoriteDao favoriteDao;

    @Autowired
    private FavoriteDataInit(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @PostConstruct
    private void favouriteDataInit() {
        favoriteDao.persist(Favorite.builder().id(1L).itemId(1L).build());
        favoriteDao.persist(Favorite.builder().id(2L).itemId(2L).build());
        favoriteDao.persist(Favorite.builder().id(3L).itemId(3L).build());
        favoriteDao.persist(Favorite.builder().id(4L).itemId(4L).build());
        favoriteDao.persist(Favorite.builder().id(5L).itemId(5L).build());
        favoriteDao.persist(Favorite.builder().id(6L).itemId(6L).build());
        favoriteDao.persist(Favorite.builder().id(7L).itemId(7L).build());
        favoriteDao.persist(Favorite.builder().id(8L).itemId(8L).build());
    }
}
