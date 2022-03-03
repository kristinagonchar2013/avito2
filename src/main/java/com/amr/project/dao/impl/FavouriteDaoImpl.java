package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.FavouriteDao;
import com.amr.project.model.entity.Favorite;
import org.springframework.stereotype.Repository;

@Repository
public class FavouriteDaoImpl extends ReadWriteDaoImpl<Favorite, Long> implements FavouriteDao {
}
