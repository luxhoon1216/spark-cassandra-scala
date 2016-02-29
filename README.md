# spark-cassandra-scala

Reference: http://www.datastax.com/dev/blog/accessing-cassandra-from-spark-in-java


### Build
##### gradle clean build

### Upload files to Spark server
##### create spark-cassandra-java/ directory in spark server
mkdir spark-cassandra-scala
##### upload build/libs/spark-cassandra-scala-0.0.1-SNAPSHOT.jar

### run spark-submit
##### go to spark-cassandra-java/ in spark server
cd spark-cassandra-scala
##### run spark-submit
spark-submit --class ScalaDemo --jars build/libs/spark-cassandra-scala-0.0.1-SNAPSHOT.jar \
--master {master} spark-cassandra-scala-0.0.1-SNAPSHOT.jar {spark master} {cassandra end point}


spark-submit --class ScalaDemo --jars build/libs/spark-cassandra-scala-0.0.1-SNAPSHOT.jar,$(echo libs/*.jar | tr ' ' ',') --master local[4] spark-cassandra-scala-0.0.1-SNAPSHOT.jar local 192.168.99.100