package com.githab.meraving.voter.model;

public enum Permission {
    DISH_READ("DISH:READ"),
    DISH_WRITE("DISH:WRITE"),
    MEAL_READ("MEAL:READ"),
    MEAL_WRITE("MEAL:WRITE"),
    MENU_READ("MENU:READ"),
    MENU_WRITE("MENU:WRITE"),
    RESTAURANT_READ("RESTAURANT:READ"),
    RESTAURANT_WRITE("RESTAURANT:WRITE"),
    VOTE_READ("VOTE:READ"),
    VOTE_WRITE("VOTE:WRITE"),
    USER_READ("USER:READ"),
    USER_WRITE("USER:WRITE");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}