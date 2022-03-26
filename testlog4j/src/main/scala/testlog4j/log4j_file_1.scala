package testlog4j

import org.apache.spark.sql.SparkSession
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager


object log4j_file_1 {
  
  def main(args: Array[String])
  {
    println("Starting to test log4j..")
    
    val logger: Logger = LogManager.getLogger(this.getClass.getName)
    
     logger.info("Logger : Welcome to log4j")

	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  println("log level:::::"+ logger.getLevel())
	  
	  val spark=SparkSession.builder().appName("spark_1").master("local[*]").getOrCreate()
    
	  spark.conf.getAll.foreach(println)
  }
  
}