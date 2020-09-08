package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class DishDto {

    private Long id;

    @NotNull
    private MenuDto menuDto;

    @NotNull
    private MealDto mealDto;

    @NotNull
    private BigDecimal price;


    public static DishDto of(Dish dish) {
        return new DishDto(dish.getId(), MenuDto.of(dish.getMenu()),MealDto.of(dish.getMeal()),dish.getPrice());
    }
}
