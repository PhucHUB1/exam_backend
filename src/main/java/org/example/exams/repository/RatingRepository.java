package org.example.exams.repository;


import org.example.exams.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByUserIdAndPlaceId(int userId, Long placeId);
}