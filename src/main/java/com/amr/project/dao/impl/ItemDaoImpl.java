package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.enums.EstablishedStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemDaoImpl extends ReadWriteDaoImpl<Item, Long> implements ItemDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<Item> findAllByStatus(EstablishedStatus establishedStatus) {
        return em.createQuery("from Item where establishedStatus =: establishedStatus", Item.class)
                .setParameter("establishedStatus", establishedStatus)
                .getResultList();
    }
}
