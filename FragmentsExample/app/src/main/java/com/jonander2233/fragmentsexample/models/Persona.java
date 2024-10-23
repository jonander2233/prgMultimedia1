package com.jonander2233.fragmentsexample.models;

public class Persona {
    private final String name;
    private final String description;

    public Persona(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

}
