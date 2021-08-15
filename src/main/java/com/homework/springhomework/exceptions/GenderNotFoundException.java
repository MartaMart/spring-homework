package com.homework.springhomework.exceptions;

public class GenderNotFoundException extends RuntimeException {
    public GenderNotFoundException() {
        super("There's no such gender. Available gender: \"m\" for male and \"w\" for female");
    }
}
