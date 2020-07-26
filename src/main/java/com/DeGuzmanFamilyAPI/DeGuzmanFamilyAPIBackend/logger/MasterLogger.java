package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class MasterLogger {

	static boolean append = true;
	public final static Logger masterLogger = Logger.getLogger(ClassName.class.getName());
	
	public void createLog() throws SecurityException, IOException  {
		File masterLogDirectory = new File("C:\\\\EJ-Projects\\\\DeGuzmanFamilyAPI-Backend\\\\log");
		if(!masterLogDirectory.exists()) {
			masterLogDirectory.mkdirs();
			System.out.println("Created directory" + " " + masterLogDirectory);  
		}
		
		FileHandler masterLoggerHandler;
		String path = "C:\\EJ-Projects\\DeGUzmanFamilyAPI-Backend\\log\\master-logger.log";
		masterLoggerHandler = new FileHandler(path,append);
		masterLogger.addHandler(masterLoggerHandler);
	}
}
