package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    public static UserDto of(User user) {
        return new UserDto(user.getId(), user.getName(), user.getPassword());
    }
}
