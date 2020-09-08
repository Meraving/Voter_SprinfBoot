package com.githab.meraving.voter.dto;

import com.githab.meraving.voter.model.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateVoteDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long menuId;
}
