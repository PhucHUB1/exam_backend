package org.example.exams.dto.rating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private Long id;
    private Long placeId;
    private Long userId;
    private int rating;

}