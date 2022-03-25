package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Картинки (аватар пользователя, фото товара)")
@Data
@NoArgsConstructor
public class ImageDto {
    private Long id;
    private byte[] picture;
    private Boolean isMain;
}
