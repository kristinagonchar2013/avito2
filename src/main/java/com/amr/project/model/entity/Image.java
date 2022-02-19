package com.amr.project.model.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@Builder
public class Image {
    //TODO картинки будем хранить в БД (для удобства, хотя это и плохая практика)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private byte[] picture;
    @Column
    private Boolean isMain = false;

    public Image() {

    }
}
