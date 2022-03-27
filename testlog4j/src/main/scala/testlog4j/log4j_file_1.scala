package testlog4j

import org.apache.spark.sql.SparkSession
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager


object log4j_file_1 {
  
  def main(args: Array[String])
  {
    println("Starting to test log4j..")
    
    val logger: Logger = LogManager.getLogger(this.getClass.getName)
    
     logger.error("Logger : Welcome to log4j::"+this.getClass.getName)

	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	    logger.error("======");
	  println("log level:::::"+ logger.getLevel())
	  
	
	  
	  val spark=SparkSession.builder().appName("spark_1").master("local[*]").getOrCreate()
    
	  spark.conf.getAll.foreach(println)
	  
	  println("=============================================")
	  println(" ")
	  spark.conf.set("spark.app.name","new_spark_app_name")

	  println("New=="+spark.conf.get("spark.app.name"))
	    
	  spark.close()
	  	  println("end")
  }
  
}