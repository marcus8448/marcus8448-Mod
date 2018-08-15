package com.marcus8448.mods.marcus8448mod.utils;

import org.apache.logging.log4j.LogManager;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class Logger {
    private static org.apache.logging.log4j.Logger Mlog;

    public static org.apache.logging.log4j.Logger getLogger() {
        Mlog = LogManager.getFormatterLogger(Constants.MODID);
        return Mlog;
    }
}
