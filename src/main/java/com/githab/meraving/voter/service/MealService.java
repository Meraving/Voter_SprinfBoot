package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateMealDto;
import com.githab.meraving.voter.dto.MealDto;
import com.githab.meraving.voter.dto.UpdateMealDto;

import java.util.List;


public interface MealService {

    MealDto create(CreateMealDto createMealDto);

    MealDto get(Long id);

    MealDto update(Long id, UpdateMealDto updateMealDto);

    void delete(Long id);

    List<MealDto> getAll();
}
