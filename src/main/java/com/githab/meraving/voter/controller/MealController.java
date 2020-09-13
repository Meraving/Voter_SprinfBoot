package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateMealDto;
import com.githab.meraving.voter.dto.MealDto;
import com.githab.meraving.voter.dto.UpdateMealDto;
import com.githab.meraving.voter.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/meal")
    @PreAuthorize("HasAthority('meal:write')")
    public MealDto createMeal(@RequestBody @Valid CreateMealDto createMealDto) {
        return mealService.create(createMealDto);
    }

    @GetMapping("/meal/{id}")
    @PreAuthorize("HasAthority('meal:read')")
    public MealDto get(@PathVariable("id") Long id) {
        return mealService.get(id);
    }

    @PutMapping("/meal/{id}")
    public MealDto updateMeal(@PathVariable("id") Long id, @RequestBody @Valid UpdateMealDto updateMealDto) {
        return mealService.update(id, updateMealDto);
    }

    @DeleteMapping("/meal/{id}")
    public void deleteMeal(@PathVariable("id") Long id) {
        mealService.delete(id);
    }

    @GetMapping("/meals")
    public List<MealDto> getAll() {
        return mealService.getAll();
    }


}
