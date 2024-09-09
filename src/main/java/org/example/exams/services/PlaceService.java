package org.example.exams.services;
import org.example.exams.dto.place.CreatePlaceDto;
import org.example.exams.dto.place.PlaceDto;
import org.example.exams.dto.place.UpdatePlaceDto;

import java.util.List;

public interface PlaceService {
    public List<PlaceDto> getAllPlaces();
    public PlaceDto getPlaceById(int id);
    public void createPlace(CreatePlaceDto createPlaceDto);
    public void updatePlace(int id, UpdatePlaceDto updatePlaceDto);
    public void deletePlace(int id);
}