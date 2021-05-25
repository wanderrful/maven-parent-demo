package com.wanderrful.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanderrful.core.MyClass;

/**
 * Simple logging demonstration
 */
public class MyService {
    Logger logger = LoggerFactory.getLogger(MyService.class);

    public String getMessage() {
        logger.info("MyService::getMessage ENTRY");

        return MyClass.MESSAGE + "... and service!";
    }
}
