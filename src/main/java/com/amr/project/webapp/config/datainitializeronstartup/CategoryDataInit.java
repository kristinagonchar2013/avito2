package com.amr.project.webapp.config.datainitializeronstartup;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CategoryDataInit {

    private final ReadWriteDao<Category, Long> categoryReadWriteDao;

    @Autowired
    public CategoryDataInit(ReadWriteDao<Category, Long> categoryReadWriteDao) {
        this.categoryReadWriteDao = categoryReadWriteDao;
    }

    @PostConstruct
    public void shopDataInit() {
        categoryReadWriteDao.persist(Category.builder().id(1L).name("Bicycle").build());
        categoryReadWriteDao.persist(Category.builder().id(2L).name("Smartphone").build());
        categoryReadWriteDao.persist(Category.builder().id(3L).name("Table").build());
        categoryReadWriteDao.persist(Category.builder().id(4L).name("Chair").build());
    }
}
