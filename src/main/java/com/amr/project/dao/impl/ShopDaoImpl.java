package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopDao {

    @Override
    public List<Shop> findShops(String keyword) {
        return em.createQuery("SELECT s FROM Shop s WHERE s.name LIKE CONCAT('%', :keyword, '%') ORDER BY s.rating DESC", Shop.class).setParameter("keyword", keyword).getResultList();
    }
}
