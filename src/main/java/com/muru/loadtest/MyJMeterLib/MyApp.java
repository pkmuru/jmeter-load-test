package main.java.com.muru.loadtest.MyJMeterLib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by muru on Oct-02-17.
 */
public class MyApp {
    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {
        logger.info("test");
        System.out.println("Welcome");
    }
}
