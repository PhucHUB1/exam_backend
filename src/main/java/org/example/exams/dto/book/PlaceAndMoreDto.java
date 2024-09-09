package org.example.exams.dto.book;

import lombok.Getter;
import lombok.Setter;
import org.example.exams.entity.Rating;

import java.util.List;

@Getter
@Setter
public class PlaceAndMoreDto {
    private Long id;

    private String name;
    private String description;

    private double averageRating = 0.0;
    private List<Rating> ratings;
}
