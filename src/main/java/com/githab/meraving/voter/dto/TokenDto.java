package com.githab.meraving.voter.dto;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class TokenDto {

    private final String token;

    private final Date created;

    private final Date expires;

    private final String type;

}
