package com.homework.springhomework.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.homework.springhomework.exceptions.GenderNotFoundException;

import java.util.stream.Stream;

enum Gender {

    MALE("m"), FEMALE("w");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Gender getGenderFromValue(final String value) {
        return Stream.of(Gender.values()).filter(gender -> gender.value.equalsIgnoreCase(value)).findFirst().orElseThrow(GenderNotFoundException::new);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
