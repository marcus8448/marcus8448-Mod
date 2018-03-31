package com.marcus8448.mod.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
	private static org.apache.logging.log4j.Logger Mlog;

	public static org.apache.logging.log4j.Logger getLogger() {
			Mlog = LogManager.getFormatterLogger(Constants.MODID);
		return Mlog;
	}
}
