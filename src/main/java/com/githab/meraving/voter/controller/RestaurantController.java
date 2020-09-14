package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateRestaurantDto;
import com.githab.meraving.voter.dto.RestaurantDto;
import com.githab.meraving.voter.dto.UpdateRestaurantDto;
import com.githab.meraving.voter.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('RESTAURANT:WRITE')")
    public RestaurantDto createRestaurant(@RequestBody @Valid CreateRestaurantDto createRestaurantDto) {
        return restaurantService.create(createRestaurantDto);
    }

    @GetMapping("/restaurant/{id}")
    @PreAuthorize("hasAnyAuthority('RESTAURANT:READ')")
    public RestaurantDto getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.get(id);
    }

    @PutMapping("/restaurant/{id}")
    @PreAuthorize("hasAnyAuthority('RESTAURANT:WRITE')")
    public RestaurantDto updateRestaurant(@PathVariable("id") Long id, @RequestBody @Valid UpdateRestaurantDto updateRestaurantDto) {
        return restaurantService.update(id, updateRestaurantDto);
    }

    @DeleteMapping("/restaurant/{id}")
    @PreAuthorize("hasAnyAuthority('RESTAURANT:WRITE')")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.delete(id);
    }

    @GetMapping("/restaurants")
    @PreAuthorize("hasAnyAuthority('RESTAURANT:READ')")
    public List<RestaurantDto> getAll() {
        return restaurantService.getAll();
    }
}
