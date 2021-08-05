package com.homework.springhomework.models.student;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Gender {

    MALE("m"), FEMALE("w");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Gender getGenderFromValue(final String value) {
        return Stream.of(Gender.values()).filter(e -> e.value.equalsIgnoreCase(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
