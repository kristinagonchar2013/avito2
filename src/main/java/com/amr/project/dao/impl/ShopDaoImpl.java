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
    public List<Shop> findAllByStatus(EstablishedStatus establishedStatus) {
        return em.createQuery("from Shop where establishedStatus =: establishedStatus", Shop.class)
                .setParameter("establishedStatus", establishedStatus)
                .getResultList();
    }
}
