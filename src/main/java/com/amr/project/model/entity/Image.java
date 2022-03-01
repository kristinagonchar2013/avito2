package com.amr.project.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    //TODO картинки будем хранить в БД (для удобства, хотя это и плохая практика)
    private Long id;
    private byte[] picture;
    private Boolean isMain;
}
