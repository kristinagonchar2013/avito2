package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.enums.EstablishedStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ShopDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopDao {

    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<Shop> findShops(String keyword) {
        return em.createQuery("SELECT s FROM Shop s WHERE s.name LIKE CONCAT('%', :keyword, '%') AND s.status = 'approved' ORDER BY s.rating DESC", Shop.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }
}
