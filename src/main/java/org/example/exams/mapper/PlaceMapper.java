package org.example.exams.mapper;


import org.example.exams.dto.place.CreatePlaceDto;
import org.example.exams.dto.place.PlaceDto;
import org.example.exams.dto.place.UpdatePlaceDto;
import org.example.exams.entity.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    /*to Dto*/
    @Mapping(source = "name", target = "name")
    PlaceDto placeToPlaceDto(Place place);

    /*to Dto*/
    List<PlaceDto> placeListToPlaceAndMoreListDto(List<Place> placeList);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Place createPlaceDtoToPlace(CreatePlaceDto createPlaceDto);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Place updatePlaceDtoToPlace(UpdatePlaceDto updatePlaceDto, @MappingTarget Place place);
}