package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDto {
    private Long id;
    private byte[] picture;
}
