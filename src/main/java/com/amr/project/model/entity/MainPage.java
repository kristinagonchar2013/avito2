package com.amr.project.model.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Builder
@Table
public class MainPage {
    private Long id;
    private List<Shop> shopList;
    private List<Item> itemList;

    public MainPage() {

    }
}
