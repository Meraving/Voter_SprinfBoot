package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateRestaurantDto;
import com.githab.meraving.voter.dto.RestaurantDto;
import com.githab.meraving.voter.dto.UpdateRestaurantDto;
import com.githab.meraving.voter.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public RestaurantDto createRestaurant(@RequestBody @Valid CreateRestaurantDto createMealDto) {
        return restaurantService.create(createMealDto);
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDto getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.get(id);
    }

    @PutMapping("/restaurant/{id}")
    public RestaurantDto updateRestaurant(@PathVariable("id") Long id, @RequestBody @Valid UpdateRestaurantDto updateRestaurantDto) {
        return restaurantService.update(id, updateRestaurantDto);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.delete(id);
    }

    @GetMapping("/restaurants")
    public List<RestaurantDto> getAll() {
        return restaurantService.getAll();
    }

}
