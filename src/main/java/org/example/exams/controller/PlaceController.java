package org.example.exams.controller;
import org.example.exams.entity.Place;
import org.example.exams.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
    @PostMapping("/{placeId}/rate")
    public Place ratePlace(@PathVariable Long placeId, @RequestParam int userId, @RequestParam int rating) {
        return placeService.ratePlace(placeId, userId, rating);
    }

}
