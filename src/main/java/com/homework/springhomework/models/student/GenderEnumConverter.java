package com.homework.springhomework.models.student;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenderEnumConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String value) {
        return Gender.valueOf(value);
    }
}
