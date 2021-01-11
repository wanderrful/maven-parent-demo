package org.baeldung;

import org.baeldung.service.MyService;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyService myService = new MyService();

        Logger logger = Logger.getLogger(App.class.toString());

        logger.info( myService.getMessage() );
    }
}
