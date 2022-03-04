package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favorite")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @Id
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Shop> shops;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "favorite", cascade = CascadeType.ALL)
    @MapsId // аннотация, для подгружения айдишника юзера
    @JoinColumn(name = "id")
    private User user; //убрала optional - если есть избранное, то он точно привязан к юзеру
}