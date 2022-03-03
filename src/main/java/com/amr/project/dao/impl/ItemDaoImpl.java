package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.model.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl extends ReadWriteDaoImpl<Item, Long> implements ItemDao {
    @Override
    public List<Item> findItems(String keyword) {
        return em.createQuery("SELECT i FROM Item i WHERE i.name LIKE CONCAT('%', :keyword, '%')", Item.class).setParameter("keyword", keyword).getResultList();
    }
}
