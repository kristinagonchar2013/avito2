package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.CategoryService;


public class CategoryServiceImpl extends ReadWriteServiceImpl<Category, Long> implements CategoryService {
    public CategoryServiceImpl(ReadWriteDao<Category, Long> dao) {
        super(dao);
    }
}
