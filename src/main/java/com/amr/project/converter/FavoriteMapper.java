package com.amr.project.converter;

import com.amr.project.model.dto.FavoriteDto;
import com.amr.project.model.entity.Favorite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {
    Favorite favoriteDtoToFavorite(FavoriteDto favoriteDto);

    FavoriteDto favoriteToFavoriteDto(Favorite favorite);
}
