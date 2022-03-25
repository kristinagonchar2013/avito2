package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Категории товаров")
@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
}
