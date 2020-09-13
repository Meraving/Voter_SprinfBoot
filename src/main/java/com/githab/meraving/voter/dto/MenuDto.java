package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDto {

    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private RestaurantDto restaurantDto;

    public static MenuDto of(Menu menu) {
        return new MenuDto(menu.getId(), menu.getMenudate(), RestaurantDto.of(menu.getRestaurant()));
    }
}
