package com.rest.demo.converters;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;
//Pruebas NO usadas
@Mapper(componentModel= "spring")
public interface GameToGameDTOMapper {

	GameToGameDTOMapper INSTANCE = Mappers.getMapper(GameToGameDTOMapper.class);
    @Mappings({
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description"),
        @Mapping(target="year", source="year"),

      })
	public GameDto gameToGameDTO(Game game);
    @Mappings({
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description"),
        @Mapping(target="year", source="year"),

      })
	public Game gameDTOToGame(GameDto gameDTO);

	
}
 