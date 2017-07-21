package py.una.pol.cursojava;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerTest {
	
	private static final Logger logger = LogManager.getLogger(LoggerTest.class);

	public static void main(String[] args) {
		
		logger.trace("Mensaje de tipo TRACE");
		logger.debug("Mensaje de tipo DEBUG");
		logger.info("Mensaje de tipo INFO");
		logger.warn("Mensaje de tipo WARN");
		logger.error("Mensaje de tipo ERROR");
		logger.fatal("Mensaje de tipo FATAL");

		try {
			int resultado = 100/0;
		} catch(Exception e) {
			logger.error("Logueamos una excepcion", e);
		}
		
	}

}
