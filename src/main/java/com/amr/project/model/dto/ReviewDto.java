package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
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