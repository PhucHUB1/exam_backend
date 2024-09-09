package org.example.exams.mapper;
import org.example.exams.dto.rating.RatingDto;
import org.example.exams.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);

    @Mapping(source = "place.id", target = "placeId")
    @Mapping(source = "user.id", target = "userId")
    RatingDto ratingToRatingDto(Rating rating);

    @Mapping(source = "placeId", target = "place.id")
    @Mapping(source = "userId", target = "user.id")
    Rating ratingDtoToRating(RatingDto ratingDto);
}
