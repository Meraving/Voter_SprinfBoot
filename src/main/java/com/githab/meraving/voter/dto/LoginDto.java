package com.githab.meraving.voter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class LoginDto {

    @NotBlank
    private final String name;

    @NotBlank
    private final String password;

}
