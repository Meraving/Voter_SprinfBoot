package com.githab.meraving.voter.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {


    USER(new HashSet<Permission>(Arrays.asList(Permission.DISH_READ,
            Permission.MEAL_READ,
            Permission.MENU_READ,
            Permission.USER_READ,
            Permission.VOTE_READ,
            Permission.RESTAURANT_READ,
            Permission.VOTE_WRITE))),

    ADMIN(new HashSet<Permission>(Arrays.asList(Permission.DISH_READ,
            Permission.MEAL_READ,
            Permission.MENU_READ,
            Permission.USER_READ,
            Permission.VOTE_READ,
            Permission.RESTAURANT_READ,
            Permission.DISH_WRITE,
            Permission.MEAL_WRITE,
            Permission.MENU_WRITE,
            Permission.USER_WRITE,
            Permission.VOTE_WRITE,
            Permission.RESTAURANT_WRITE)));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
