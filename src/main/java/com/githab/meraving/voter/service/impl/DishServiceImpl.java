package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateDishDto;
import com.githab.meraving.voter.dto.DishDto;
import com.githab.meraving.voter.dto.UpdateDishDto;
import com.githab.meraving.voter.model.Dish;
import com.githab.meraving.voter.model.Meal;
import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.repository.DishRepository;
import com.githab.meraving.voter.repository.MealRepository;
import com.githab.meraving.voter.repository.MenuRepository;
import com.githab.meraving.voter.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class DishServiceImpl implements DishService {

    private final DishRepository repository;
    private final MenuRepository menuRepository;
    private final MealRepository mealRepository;

    @Override
    public DishDto create(CreateDishDto createDishDto) {
        Assert.notNull(createDishDto, "dish must be not null");
        Menu menu = getFromOptional(menuRepository.findById(createDishDto.getMenuId()));
        Meal meal = getFromOptional(mealRepository.findById(createDishDto.getMealId()));
        Dish dish = repository.save(Dish.of(menu, meal, createDishDto.getPrice()));
        return DishDto.of(repository.save(dish));
    }

    @Override
    public DishDto get(Long id) {
        return DishDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public DishDto update(Long id, UpdateDishDto updateDishDto) {
        Assert.notNull(updateDishDto, "dish must not be null");
        Dish dish = getFromOptional(repository.findById(id));
        Menu menu = getFromOptional(menuRepository.findById(updateDishDto.getMenuId()));
        Meal meal = getFromOptional(mealRepository.findById(updateDishDto.getMealId()));
        dish.setMenu(menu);
        dish.setMeal(meal);
        dish.setPrice(updateDishDto.getPrice());
        return DishDto.of(repository.save(dish));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DishDto> getAllByMenu(Long id) {
        Menu menu = getFromOptional(menuRepository.findById(id));

        return repository.getAllByMenu(menu).stream().map(DishDto::of).collect(Collectors.toList());
    }
}
