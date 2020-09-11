package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.LoginDto;
import com.githab.meraving.voter.dto.TokenDto;
import com.githab.meraving.voter.service.TokenService;
import com.githab.meraving.voter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/auth")
public class AuthController {

    private final TokenService tokenService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/token")
    public TokenDto getToken(@RequestBody @Valid LoginDto loginDto) {


        final UserDetails userByLoginDto = userService.loadUserByUsername(loginDto.getName());

        final TokenDto token = tokenService.createToken(userByLoginDto);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getName(), loginDto.getPassword()));

        return token;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(httpServletRequest, httpServletResponse, null);
    }
}
