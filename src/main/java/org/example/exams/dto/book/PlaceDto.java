package org.example.exams.dto.book;

import lombok.Getter;
import lombok.Setter;
import org.example.exams.dto.rating.RatingDto;

import java.util.List;

@Getter
@Setter
public class PlaceDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private double averageRating;
    private List<RatingDto> ratings;

}

