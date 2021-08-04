package com.homework.springhomework.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/*"you can just annotate the class with @Slf4j which will automatically generate a logger for the class without
 * having to declare a constant. The annotation supplies a static variable called log which provides the logger
 * utilities by default"*/
@Slf4j
@Component
public class StartLogger {

    @Autowired
    public void warnLevelDisplay() {
        log.warn("hello");
    }

}
