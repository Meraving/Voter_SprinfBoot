package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.LoginDto;
import com.githab.meraving.voter.dto.TokenDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    TokenDto getToken(LoginDto loginDto);

    TokenDto createToken(UserDetails userDetails);

    boolean validateToken(String token);

    Authentication getAuthentication(String token);

    String getUserName(String token);

    String resolveToken(HttpServletRequest request);
}
