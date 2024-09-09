package org.example.exams.controller;


import org.example.exams.entity.Place;
import org.example.exams.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/add-place")
    public ResponseEntity<Place> addPlace(@RequestBody Place place, @RequestHeader("Role") String role) {
        if (!"ADMIN".equals(role)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Place createdPlace = placeService.addPlace(place);
        return new ResponseEntity<>(createdPlace, HttpStatus.CREATED);
    }


    @PutMapping("/update-place/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place updatedPlace, @RequestHeader("Role") String role) {
        if (!"ADMIN".equals(role)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Optional<Place> place = placeService.updatePlace(id, updatedPlace);
        return place.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete-place/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id, @RequestHeader("Role") String role) {
        if (!"ADMIN".equals(role)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        placeService.deletePlace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
