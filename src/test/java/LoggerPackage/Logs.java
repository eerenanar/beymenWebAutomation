package LoggerPackage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Logs {
	
	private static Logger logger = LogManager.getLogger(Logs.class);

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
