package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MealDto {

    private Long id;

    @NotBlank
    private String name;

    public static MealDto of(Meal meal) {
        return new MealDto(meal.getId(), meal.getName());
    }
}
