package org.example.exams.controller;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exams.dto.place.CreatePlaceDto;
import org.example.exams.dto.place.PlaceDto;
import org.example.exams.services.serviceImplement.PlaceServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceServiceImpl placeServiceImplement;

    public PlaceController(PlaceServiceImpl placeServiceImplement) {
        this.placeServiceImplement = placeServiceImplement;
    }

    @GetMapping
    public List<PlaceDto> getAllPlaces() {

        return placeServiceImplement.getAllPlaces();

    }

    @GetMapping("/{id}")
    public PlaceDto getPlaceById(@PathVariable int id) {
        return placeServiceImplement.getPlaceById(id);
    }


    @PostMapping
    public void createPlace(@RequestBody CreatePlaceDto createPlaceDto, HttpServletResponse response) {
        placeServiceImplement.createPlace(createPlaceDto);
        /*Trả về 201*/
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PutMapping("/{id}")
    public void updatePlace(@PathVariable int id, @RequestBody org.example.exams.dto.place.UpdatePlaceDto updatePlaceDto, HttpServletResponse response) {
        placeServiceImplement.updatePlace(id, updatePlaceDto);
        /*Trả về 204*/
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public void deletePlace(@PathVariable int id) {
        placeServiceImplement.deletePlace(id);
    }
}