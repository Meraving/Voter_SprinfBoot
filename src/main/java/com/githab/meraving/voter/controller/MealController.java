package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.model.Meal;
import com.githab.meraving.voter.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/rest")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController (MealService mealService){this.mealService = mealService;}

    @PostMapping("/meal")
    public Meal createMeal (@RequestBody Meal meal){
        return mealService.create(meal);
    }

    @GetMapping ("/meal/{id}")
    public Meal get (@PathVariable Long id){
        return mealService.get(id);
    }

    @PostMapping("/meal")
    public void updateMeal (@RequestBody Meal meal){
        mealService.update(meal);
    }

    @DeleteMapping("/meal/{id}")
    public void deleteMeal (@PathVariable Long id) {
        mealService.delete(id);
    }

    @GetMapping ("/meals")
    public List<Meal> getAll (){
        return mealService.getAll();
    }


}
