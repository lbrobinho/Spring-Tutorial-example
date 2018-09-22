package com.bo.jackson.json.demo.entity;

import lombok.Data;

@Data
public class AnotherStudent {

    private String firstName;

    private String lastName;

    public AnotherStudent() {

    }

    public AnotherStudent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
