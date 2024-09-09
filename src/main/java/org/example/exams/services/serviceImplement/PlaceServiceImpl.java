package org.example.exams.services.serviceImplement;


import org.example.exams.dto.book.PlaceDto;
import org.example.exams.entity.Place;
import org.example.exams.entity.Rating;
import org.example.exams.entity.User;
import org.example.exams.mapper.PlaceMapper;
import org.example.exams.repository.PlaceRepository;
import org.example.exams.repository.RatingRepository;
import org.example.exams.repository.UserRepository;
import org.example.exams.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    private final PlaceMapper placeMapper = PlaceMapper.INSTANCE;


    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public PlaceDto getPlaceById(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));
        return placeMapper.placeToPlaceDto(place);
    }

    // Add a new place (Admin only)
    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    // Update a place (Admin only)
    @Override
    public Optional<Place> updatePlace(Long placeId, Place updatedPlace) {
        return placeRepository.findById(placeId).map(existingPlace -> {
            existingPlace.setName(updatedPlace.getName());
            existingPlace.setDescription(updatedPlace.getDescription());
            return placeRepository.save(existingPlace);
        });
    }

    // Delete a place (Admin only)
    @Override
    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }

    // Allow a user to rate a place
    @Override
    public PlaceDto ratePlace(Long placeId, int userId, int ratingValue) {
        // Find the place by ID
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));

        // Find the user by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the user has already rated the place
        Rating rating = ratingRepository.findByUserIdAndPlaceId(userId, placeId);
        if (rating == null) {
            // Create a new rating if it does not exist
            rating = new Rating();
            rating.setUser(user);
            rating.setPlace(place);
        }


        rating.setRating(ratingValue);
        ratingRepository.save(rating);

        place.calculateAverageRating();
        placeRepository.save(place);

        return placeMapper.placeToPlaceDto(place);
    }
}