package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Data
@Builder
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
}
