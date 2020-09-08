package com.githab.meraving.voter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateDishDto {

    private Long id;

    @NotNull
    private Long menuId;

    @NotNull
    private Long mealId;

    @NotNull
    private BigDecimal price;



}
