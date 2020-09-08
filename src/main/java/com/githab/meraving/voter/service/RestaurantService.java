package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateRestaurantDto;
import com.githab.meraving.voter.dto.RestaurantDto;
import com.githab.meraving.voter.dto.UpdateRestaurantDto;

import java.util.List;


public interface RestaurantService {

    RestaurantDto create(CreateRestaurantDto createRestaurantDto);

    RestaurantDto get(Long id);

    RestaurantDto update(Long id, UpdateRestaurantDto updateRestaurantDto);

    void delete(Long id);

    List<RestaurantDto> getAll();
}
