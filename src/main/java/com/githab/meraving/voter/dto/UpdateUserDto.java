package com.githab.meraving.voter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateUserDto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;


}
