package org.example.exams.services;
import org.example.exams.dto.book.PlaceDto;
import org.example.exams.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    List<Place> getAllPlaces();
    PlaceDto getPlaceById(Long id);
    PlaceDto ratePlace(Long placeId, int userId, int ratingValue);
    Place addPlace(Place place);
    Optional<Place> updatePlace(Long placeId, Place updatedPlace);
    void deletePlace(Long id);

}