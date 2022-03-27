package testlog4j


import org.apache.spark.sql.SparkSession
import java.util.Properties;
object jdbc {
  
  
 def main(args: Array[String]){
   
   println("JDBC Start::")
   
   val spark=SparkSession.builder.master("local[*]").getOrCreate()
   
   spark.sparkContext.setLogLevel("ERROR")
   spark.conf.getAll.foreach(println)
   

val jdbcDF = spark.read
  .format("jdbc")
.option("url", "jdbc:postgresql://localhost:5432/postgres")
.option("user", "postgres")
.option("password", "postgres")
.option("dbtable","public.t1")
.load()
  
  jdbcDF.show(false)
   
  
  val connectionProperties = new Properties()
connectionProperties.put("user", "postgres")
connectionProperties.put("password", "postgres")


val jdbcDF2 = spark.read.jdbc("jdbc:postgresql://localhost:5432/postgres","public.t1",connectionProperties)
 
jdbcDF2.show(false)
 }
}