package testlog4j


import org.apache.spark.sql.SparkSession

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
   
 }
}