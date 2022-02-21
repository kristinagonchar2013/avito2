package com.amr.project.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {
    private Long id;
    private String dignity;
    private String flaw;
    private String text;
    private Date date;
    private int rating;
    private ItemDto item;
    private String username;
}