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
public class UpdateMenuDto {

    @NotNull
    private LocalDate date;

    @NotNull
    private Long restaurantId;

}
