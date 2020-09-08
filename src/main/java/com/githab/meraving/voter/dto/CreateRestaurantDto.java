package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateRestaurantDto {

    @NotBlank
    private String name;
}
