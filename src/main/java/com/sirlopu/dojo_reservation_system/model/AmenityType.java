package com.sirlopu.dojo_reservation_system.model;

public enum AmenityType {
    CODING("CODING"), GAME_NIGHT("GAME_NIGHT"), BIRTHDAY_PARTY("BIRTHDAY_PARTY");

    private final String name;

    private AmenityType(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}