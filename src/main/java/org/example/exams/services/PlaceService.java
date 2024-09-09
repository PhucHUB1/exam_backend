package org.example.exams.services;
import org.example.exams.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    List<Place> getAllPlaces();
    Optional<Place> getPlaceById(Long placeId);
    Place addPlace(Place place);
    Optional<Place> updatePlace(Long placeId, Place updatedPlace);
    void deletePlace(Long id);
    Place ratePlace(Long placeId, int userId, int rating);
}