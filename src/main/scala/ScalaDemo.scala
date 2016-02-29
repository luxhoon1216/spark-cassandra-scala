import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.datastax.spark.connector._
import com.datastax.spark.connector.writer._

object ScalaDemo {
  def main(args: Array[String]) {
    val conf = new SparkConf(true).set("spark.cassandra.connection.host", args(1))
    val sc = new SparkContext(args(0), "Spark Cassandra Scala", conf)
 
    val rdd = sc.cassandraTable("test", "kv")
    if(!rdd.isEmpty()) {
      println("count=" + rdd.count)
      println(rdd.first)
      println(rdd.map(_.getInt("value")).sum)  
    }
    
    val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
    collection.saveToCassandra("test", "kv", SomeColumns("key", "value"))  
  }
}