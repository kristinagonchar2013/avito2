package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.PaginationShopDao;
import com.amr.project.model.entity.Shop;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaginationShopDaoImpl implements PaginationShopDao {
    @PersistenceContext
    private EntityManager em;

    public Page<Shop> getAllShop(Pageable pageable) {
        Query query = em.createQuery("select a from Shop a");
        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        query.setFirstResult((pageNo) * pageSize);
        query.setMaxResults(pageSize);
        List<Shop> shops = query.getResultList();
        Query queryCount = em.createQuery("Select count(a.id) From Shop a");
        long count = (long) queryCount.getSingleResult();
        return new PageImpl<Shop>(shops, pageable, count);
    }
    @Override
    public List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Shop> pagedResult = getAllShop(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Shop>();
        }
    }
}
