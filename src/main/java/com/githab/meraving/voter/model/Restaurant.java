package com.githab.meraving.voter.model;

import com.githab.meraving.voter.dto.CreateMealDto;
import com.githab.meraving.voter.dto.CreateRestaurantDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@Data
@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurant_unique_name_idx")})
public class Restaurant extends AbstractNamedEntity{

    public static Restaurant of(CreateRestaurantDto createRestaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(createRestaurantDto.getName());
        return restaurant;
    }

}
