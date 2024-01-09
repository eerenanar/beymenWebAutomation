package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {
	static Logger logger = Logger.getLogger(Log.class);
	public Log(){
		//String log4jConfPath = "/log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
		//DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");
	}
	public void info(String message){
		logger.info(message);
	}
	public void warn(String message){
		logger.warn(message);
	}
	public void error(String message){
		logger.error(message);
	}
}
