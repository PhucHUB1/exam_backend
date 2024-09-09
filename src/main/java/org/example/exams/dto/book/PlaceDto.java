package org.example.exams.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDto {
    private Long id;

    private String name;
    private String description;

    private double averageRating = 0.0;

}

