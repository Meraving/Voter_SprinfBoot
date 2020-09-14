package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateDishDto;
import com.githab.meraving.voter.dto.DishDto;
import com.githab.meraving.voter.dto.UpdateDishDto;
import com.githab.meraving.voter.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class DishController {

    private final DishService dishService;

    @Autowired

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/dish")
    @PreAuthorize("hasAnyAuthority('DISH:WRITE')")
    public DishDto createMeal(@RequestBody @Valid CreateDishDto createDishDto) {
        return dishService.create(createDishDto);
    }

    @GetMapping("/dish/{id}")
    @PreAuthorize("hasAnyAuthority('DISH:READ')")
    public DishDto get(@PathVariable("id") Long id) {
        return dishService.get(id);
    }

    @PutMapping("/dish/{id}")
    @PreAuthorize("hasAnyAuthority('DISH:WRITE')")
    public DishDto updateMeal(@PathVariable("id") Long id, @RequestBody @Valid UpdateDishDto updateDishDto) {
        return dishService.update(id, updateDishDto);
    }

    @DeleteMapping("/dish/{id}")
    @PreAuthorize("hasAnyAuthority('DISH:WRITE')")
    public void deleteMeal(@PathVariable("id") Long id) {
        dishService.delete(id);
    }

    @GetMapping("/dishes/{menuId}")
    @PreAuthorize("hasAnyAuthority('DISH:READ')")
    public List<DishDto> getAll(@PathVariable("menuId") Long id) {
        return dishService.getAllByMenu(id);
    }

}
