package org.example.exams.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "place")
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private double averageRating = 0.0;


    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Rating> ratings;



    public void calculateAverageRating() {
        if (ratings != null && !ratings.isEmpty()) {
            this.averageRating = ratings.stream()
                    .mapToDouble(Rating::getRating)
                    .average().orElse(0.0);
        }
    }
}