package org.example.exams.mapper;


import org.example.exams.dto.book.PlaceDto;
import org.example.exams.entity.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {RatingMapper.class})
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    @Mapping(source = "ratings", target = "ratings")
    PlaceDto placeToPlaceDto(Place place);

    Place placeDtoToPlace(PlaceDto placeDto);
}
