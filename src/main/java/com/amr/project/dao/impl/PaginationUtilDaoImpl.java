package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.PaginationUtilDao;
import org.springframework.data.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class PaginationUtilDaoImpl<T> implements PaginationUtilDao<T> {

    private final Class<T> clazz;

    @PersistenceContext
    protected EntityManager em;

    @SuppressWarnings("unchecked")
    public PaginationUtilDaoImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public Page<T> getAllEntity(Pageable pageable) {
        Query query = em.createQuery("Select u From " + clazz.getName() + " u"  + " order by  u.rating" , clazz );
        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        query.setFirstResult((pageNo) * pageSize);
        query.setMaxResults(pageSize);
        List<T> entity = query.getResultList();
        Query queryCount = em.createQuery("Select count(u.id) From " + clazz.getName() + " u", Long.class);
        long count = (long) queryCount.getSingleResult();
        return new PageImpl<T>(entity, pageable, count);
    }

    @Override
    public List<T> getAllEntities(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<T> pagedResult = getAllEntity(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<T>();
        }
    }
    @Override
    public <T> int getTotalPages(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<T> page = (Page<T>) getAllEntity(paging);
        return page.getTotalPages();
   }
}
