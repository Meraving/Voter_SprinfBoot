package com.githab.meraving.voter.model;

import com.githab.meraving.voter.dto.CreateMealDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "meal_unique_name_idx")})
public class Meal extends AbstractNamedEntity {

    public static Meal of(CreateMealDto createMealDto) {
        Meal meal = new Meal();
        meal.setName(createMealDto.getName());
        return meal;
    }
}
