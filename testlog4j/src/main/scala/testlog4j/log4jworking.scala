package testlog4j

import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import org.apache.log4j.Level

object log4jworking {
  
  
  def main(args: Array[String]){
    
    println("Testing log4j")
    
    val logger: Logger = LogManager.getLogger(this.getClass.getName)
    
    PropertyConfigurator.configure(args(0))
     logger.info("Logger : Welcome to log4j::"+this.getClass.getName)

     logger.setLevel(Level.DEBUG)
     logger.setLevel(Level.INFO)
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	    logger.error("======");
	  println("log level:::::"+ logger.getLevel)
	  

	  Logger.getLogger("org").setLevel(Level.OFF)
    
	  Logger.getLogger("akka").setLevel(Level.OFF)
	  
	  logger.info("Testing logger INFO")
	  
  }
}