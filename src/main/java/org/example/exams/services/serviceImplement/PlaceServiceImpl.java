package org.example.exams.services.serviceImplement;


import org.example.exams.dto.place.CreatePlaceDto;
import org.example.exams.dto.place.PlaceDto;
import org.example.exams.dto.place.UpdatePlaceDto;
import org.example.exams.entity.Place;
import org.example.exams.mapper.PlaceMapper;
import org.example.exams.repository.PlaceRepository;

import org.example.exams.services.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> placeDtos = PlaceMapper.INSTANCE.placeListToPlaceAndMoreListDto(places);
        return placeDtos;
    }

    @Override
    public void createPlace(CreatePlaceDto createPlaceDto) {
        Place place = PlaceMapper.INSTANCE.createPlaceDtoToPlace(createPlaceDto);
        placeRepository.save(place);
    }

    @Override
    public void updatePlace(int id, UpdatePlaceDto updatePlaceDto) {
        /*Tìm và update*/
        Place place = placeRepository.findById(id).orElse(null);
        PlaceMapper.INSTANCE.updatePlaceDtoToPlace(updatePlaceDto, place);
        placeRepository.save(place);

    }

    @Override
    public void deletePlace(int id) {
        placeRepository.deleteById(id);
    }

    @Override
    public PlaceDto getPlaceById(int id) {
        Place place = placeRepository.findById(id).orElse(null);
        PlaceDto placeDto = PlaceMapper.INSTANCE.placeToPlaceDto(place);
        return placeDto;
    }
}