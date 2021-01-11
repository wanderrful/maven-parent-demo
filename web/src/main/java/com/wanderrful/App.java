package com.wanderrful;

import com.wanderrful.service.MyService;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final MyService myService = new MyService();

        final Logger logger = Logger.getLogger(App.class.toString());
        logger.info(myService.getMessage());
    }
}
