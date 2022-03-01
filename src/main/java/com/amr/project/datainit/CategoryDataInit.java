package com.amr.project.datainit;

import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CategoryDataInit {

    private final CategoryDao categoryDao;

    @Autowired
    private CategoryDataInit(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @PostConstruct
    private void shopDataInit() {
        categoryDao.persist(Category.builder().id(1L).name("Bicycle").build());
        categoryDao.persist(Category.builder().id(2L).name("Smartphone").build());
        categoryDao.persist(Category.builder().id(3L).name("Table").build());
        categoryDao.persist(Category.builder().id(4L).name("Chair").build());
    }
}
