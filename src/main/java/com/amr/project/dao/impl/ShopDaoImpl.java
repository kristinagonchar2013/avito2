package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ShopDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<Shop> findAllBanned() {
        return em.createQuery("from Shop where status = 'BANNED'")
                .getResultList();
    }
    @Override
    public List<Shop> findAllApproved() {
        return em.createQuery("from Shop where status = 'APPROVED'")
                .getResultList();
    }
}
