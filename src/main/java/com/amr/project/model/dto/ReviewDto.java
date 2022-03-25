package com.amr.project.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Schema(description = "Отзывы")
@Data
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String dignity;
    private String flaw;
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private int rating;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private ItemDto item;
    private UserDto user;
    private ShopDto shop;
}