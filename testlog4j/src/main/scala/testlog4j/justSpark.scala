package testlog4j

import org.apache.spark.sql.SparkSession
object justSpark {
  
  def main(args: Array[String])
  {
  println("Spark::")
  
  val spark=SparkSession.builder.appName("justSparkapp").master("local[*]").getOrCreate()
  
  spark.conf.getAll.foreach(println)
  
  println("end")
  }
  
}