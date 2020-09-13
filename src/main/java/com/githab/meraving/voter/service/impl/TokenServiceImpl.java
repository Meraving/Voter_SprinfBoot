package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.LoginDto;
import com.githab.meraving.voter.dto.TokenDto;
import com.githab.meraving.voter.service.TokenService;
import com.githab.meraving.voter.service.UserService;
import com.githab.meraving.voter.util.exception.JwtAuthException;
import com.githab.meraving.voter.util.exception.PasswordMismatchException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    @Value("${security.timeToLive}")
    private int timeToLive;

    @Value("${security.secret}")
    private String secret;

    @Value("${security.header}")
    private String header;

    @Override
    public TokenDto getToken(LoginDto loginDto) {
        UserDetails user = userService.loadUserByUsername(loginDto.getName());
        System.out.println(passwordEncoder.encode(loginDto.getPassword()));
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new PasswordMismatchException();
        }
        return createToken(user);
    }

    public TokenDto createToken(UserDetails userDetails) {

        final Date tokenCreated = new Date(System.currentTimeMillis());
        final Date tokenExpires = new Date(System.currentTimeMillis() + timeToLive * 1000);

        String token = Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(tokenCreated)
                .setExpiration(tokenExpires)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        return new TokenDto(token, tokenCreated, tokenExpires, "Bearer");

    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return claimsJws.getBody().getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthException("Jwt token is expired or invalid", HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userService.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserName(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(header);
    }

}
