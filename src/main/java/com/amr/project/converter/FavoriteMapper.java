package com.amr.project.converter;

import com.amr.project.model.dto.FavoriteDto;
import com.amr.project.model.entity.Favorite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {
    FavoriteDto favoriteToFavoriteDto(Favorite favorite);
    Favorite favoriteDtoToFavorite(FavoriteDto favoriteDto);
}
