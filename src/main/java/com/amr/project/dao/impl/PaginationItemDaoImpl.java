package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.PaginationItemDao;
import com.amr.project.model.entity.Item;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaginationItemDaoImpl implements PaginationItemDao {
    @PersistenceContext
    private EntityManager em;

    public Page<Item> getAllItem(Pageable pageable) {
        Query query = em.createQuery("select a from Item a");
        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        query.setFirstResult((pageNo) * pageSize);
        query.setMaxResults(pageSize);
        List<Item> items = query.getResultList();
        Query queryCount = em.createQuery("Select count(a.id) From Item a");
        long count = (long) queryCount.getSingleResult();
        return new PageImpl<Item>(items, pageable, count);
    }
    @Override
    public List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Item> pagedResult = getAllItem(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Item>();
        }
    }
}
