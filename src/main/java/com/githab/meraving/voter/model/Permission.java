package com.githab.meraving.voter.model;

public enum Permission {
    DISH_READ("dish:read"),
    DISH_WRITE("dish:write"),
    MEAL_READ("meal:read"),
    MEAL_WRITE("meal:write"),
    MENU_READ("menu:read"),
    MENU_WRITE("menu:write"),
    RESTAURANT_READ("restaurant:read"),
    RESTAURANT_WRITE("restaurant:write"),
    VOTE_READ("vote:read"),
    VOTE_WRITE("vote:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}