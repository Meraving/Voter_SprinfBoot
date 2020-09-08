package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteDto {

    private Long id;

    @NotNull
    private UserDto userDto;

    @NotNull
    private MenuDto menuDto;

    public static VoteDto of(Vote vote) {
        return new VoteDto(vote.getId(), UserDto.of(vote.getUser()), MenuDto.of(vote.getMenu()));
    }
}
