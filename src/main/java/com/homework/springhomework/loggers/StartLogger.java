package com.homework.springhomework.loggers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartLogger {

    @Autowired
    public void warnLevelDisplay() {
        log.warn("hello");
    }

}
