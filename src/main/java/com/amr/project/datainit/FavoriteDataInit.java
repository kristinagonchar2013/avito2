package com.amr.project.datainit;

import com.amr.project.dao.abstracts.FavoriteDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class FavoriteDataInit {

    private final FavoriteDao favoriteDao;
    private final ItemDao itemDao;
    private final ShopDao shopDao;

    @Autowired
    private FavoriteDataInit(FavoriteDao favoriteDao, ItemDao itemDao, ShopDao shopDao) {
        this.favoriteDao = favoriteDao;
        this.itemDao = itemDao;
        this.shopDao = shopDao;
    }

    @PostConstruct
    private void favouriteDataInit() {
        favoriteDao.persist(Favorite.builder().id(1L)
                .items(List.of(itemDao.findById(1L), itemDao.findById(2L)))
                .shops(List.of(shopDao.findById(1L))).build());

        favoriteDao.persist(Favorite.builder().id(2L)
                .items(List.of(itemDao.findById(3L), itemDao.findById(4L), itemDao.findById(5L))).build());

        favoriteDao.persist(Favorite.builder().id(3L)
                .shops(List.of(shopDao.findById(2L), shopDao.findById(3L), shopDao.findById(4L))).build());

        favoriteDao.persist(Favorite.builder().id(4L)
                .items(List.of(itemDao.findById(6L), itemDao.findById(7L), itemDao.findById(8L)))
                .shops(List.of(shopDao.findById(4L))).build());
    }
}
