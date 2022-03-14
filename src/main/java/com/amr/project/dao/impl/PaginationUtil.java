package com.amr.project.dao.impl;

import org.springframework.data.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class PaginationUtil {

    protected static EntityManager em;

    public <T> Page<T> getAllEntity(Pageable pageable) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        Query query = em.createQuery("select u from " + clazz.getName() + " u", clazz);
        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        query.setFirstResult((pageNo) * pageSize);
        query.setMaxResults(pageSize);
        List<T> entities = query.getResultList();
        Query queryCount = em.createQuery("Select count(u.id) From" + clazz.getName()+ " u", clazz);
        long count = (long) queryCount.getSingleResult();
        return new PageImpl<T>(entities, pageable, count);
    }

    public static <T> List<T>  getAllEntities(Integer pageNo, Integer pageSize, String sortBy) {
        PaginationUtil paginationUtil = new PaginationUtil();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<T> pagedResult = paginationUtil.getAllEntity(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<T>();
        }
    }
}
