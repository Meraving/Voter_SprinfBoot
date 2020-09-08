package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantDto {

    private Long id;

    @NotBlank
    private String name;

    public static RestaurantDto of(Restaurant restaurant) {
        return new RestaurantDto(restaurant.getId(), restaurant.getName());
    }
}
