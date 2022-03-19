package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Shop;
import com.amr.project.model.enums.EstablishedStatus;

import java.util.List;

public interface ShopDao extends ReadWriteDao<Shop, Long> {
    //List<Shop> findAllByStatus(EstablishedStatus establishedStatus);
}
