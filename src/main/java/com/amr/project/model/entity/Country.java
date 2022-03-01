package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@Builder
@NoArgsConstructor
public class Country {
    private Long id;
    private String name;
    private List<City> cities;
}
