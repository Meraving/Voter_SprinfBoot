package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateMealDto;
import com.githab.meraving.voter.dto.MealDto;
import com.githab.meraving.voter.dto.UpdateMealDto;

import java.util.List;


public interface MealService {

    public MealDto create(CreateMealDto createMealDto);

    public MealDto get(Long id);

    public MealDto update(Long id, UpdateMealDto updateMealDto);

    public void delete(Long id);

    public List<MealDto> getAll();
}
