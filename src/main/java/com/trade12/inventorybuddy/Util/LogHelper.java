package com.trade12.inventorybuddy.Util;

import org.apache.logging.log4j.Level;

/**
 * Created by kieran on 27/06/2014.
 */
public class LogHelper {
    public static void log(Level logLevel, Object object) {
        //FMLLog.log(Reference.MOD_NAME, logLevel, String.valueOf(object));
        System.out.println("[AE2 Tech] " + String.valueOf(object));
    }

    public static void all(Object object) {
        log(Level.ALL, object);
    }

    public static void debug(Object object) {
        //if (AE2Tech.LogDebug)
        log(Level.DEBUG, object);
    }

    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

    public static void error(Object object) {
        log(Level.ERROR, object);
    }

    public static void warn(Object object) {
        log(Level.WARN, object);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void off(Object object) {
        log(Level.OFF, object);
    }
}