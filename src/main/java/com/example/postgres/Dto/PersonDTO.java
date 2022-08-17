package com.example.postgres.Dto;

public class PersonDTO {
    private Long id;

    private String name;
    private String email;

    public Object getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
