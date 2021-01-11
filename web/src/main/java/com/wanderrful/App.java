package com.wanderrful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanderrful.service.MyService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final MyService myService = new MyService();

        Logger logger = LoggerFactory.getLogger(App.class);

        logger.info(myService.getMessage());
    }
}
