package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "favorite")
@Data
@Builder
public class Favorite {
    @Id
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Shop> shops;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "favorite", cascade = CascadeType.ALL, optional = false)
    private User user;

    public Favorite() {

    }
}