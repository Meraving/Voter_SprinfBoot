package com.githab.meraving.voter.config;


import com.githab.meraving.voter.service.TokenService;
import com.githab.meraving.voter.util.exception.JwtAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtTokenFilter extends GenericFilterBean {

    private final TokenService tokenService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = tokenService.resolveToken((HttpServletRequest) servletRequest);
        try {
            if (token != null && tokenService.validateToken(token)) {
                Authentication authentication = tokenService.getAuthentication(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtAuthException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(e.getHttpStatus().value());
            throw new JwtAuthException("Jwt token is expired or invalid");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


}
