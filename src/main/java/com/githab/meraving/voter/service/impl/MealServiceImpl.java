package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateMealDto;
import com.githab.meraving.voter.dto.MealDto;
import com.githab.meraving.voter.dto.UpdateMealDto;
import com.githab.meraving.voter.model.Meal;
import com.githab.meraving.voter.repository.MealRepository;
import com.githab.meraving.voter.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Override
    public MealDto create(CreateMealDto createMealDto) {
        Assert.notNull(createMealDto, "meal must be not null");
        Meal meal = repository.save(Meal.of(createMealDto));
        return MealDto.of(meal);
    }

    @Override
    public MealDto get(Long id) {
        return MealDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public MealDto update(Long id, UpdateMealDto updateMealDto) {
        Meal meal = getFromOptional(repository.findById(id));
        meal.setName(updateMealDto.getName());
        return MealDto.of(repository.save(meal));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MealDto> getAll() {
        return repository.findAll().stream().map(MealDto::of).collect(Collectors.toList());
    }
}
