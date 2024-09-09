package org.example.exams.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlaceDto {

    private String name;
    private String description;

    private double averageRating = 0.0;
}
