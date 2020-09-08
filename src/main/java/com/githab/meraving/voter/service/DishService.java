package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateDishDto;
import com.githab.meraving.voter.dto.DishDto;
import com.githab.meraving.voter.dto.UpdateDishDto;

import java.util.List;

public interface DishService {
    DishDto create(CreateDishDto createDishDto);

    DishDto get(Long id);

    DishDto update(Long id, UpdateDishDto updateDishDto);

    void delete(Long id);

    List<DishDto> getAllByMenu(Long id);
}
