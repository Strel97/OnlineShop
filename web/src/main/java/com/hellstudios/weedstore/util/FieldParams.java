package com.hellstudios.weedstore.util;

/**
 * @author strel
 */
public enum FieldParams {
    EMAIL("email"),
    PASSWORD("password"),
    NAME("name"),
    COUNTRY_CODE("country-code");

    private String name;


    FieldParams(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
