package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


import javassist.bytecode.stackmap.TypeData.ClassName;

public class GeneralTrxLogger {

	public static boolean append = true;
	public final static Logger generalTrxLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		File logDirectory = new File("./log");
		if(!logDirectory.exists()) {
			logDirectory.mkdirs();
			System.out.println("created directory" + " " + logDirectory);
		}
		String path = "C:\\EJ-Projec/ts\\DeGUzmanFamilyAPI-Backend\\log\\general-transaction.log";		
		FileHandler generalTrxFileHandler;
		generalTrxFileHandler = new FileHandler(path,append);
		generalTrxLogger.addHandler(generalTrxFileHandler);
	}
}
