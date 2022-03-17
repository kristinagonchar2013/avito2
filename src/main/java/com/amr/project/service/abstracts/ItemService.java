package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Item;
import com.amr.project.model.enums.EstablishedStatus;

import java.util.List;

public interface ItemService extends ReadWriteService<Item, Long> {
    List<Item> findAllByStatus(EstablishedStatus establishedStatus);
}
