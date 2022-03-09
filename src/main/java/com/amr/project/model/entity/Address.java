package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_index")
    private String cityIndex;
    private String street;
    private String house;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "address_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    private User user;
}
