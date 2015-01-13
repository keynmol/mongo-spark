mongo-spark
===========

Example application on how to use [mongo-hadoop][1] connector with [Apache Spark][2] on a standalone Spark cluster.

Read more details at http://codeforhire.com/2014/02/18/using-spark-with-mongodb/

[1]: https://github.com/mongodb/mongo-hadoop
[2]: https://spark.incubator.apache.org/

**This fork shows how to run it on cluster only.
**
Prerequisites
-------------

* MongoDB installed and running on mongo-host:27017
* Scala 2.10.3 and SBT 0.13.7 installed
* Apache Spark 1.2(built with Hadoop 2.4) cluster running on spark://cluster-master:7077


Running
-------

Import data into the database.

    $ mongoimport -d beowulf -c input beowulf.json -h mongo-host

Package a single JAR with all the dependencies(will create file target/scala-2.10/mongo-spark-assembly-1.0.jar):

    $ sbt assembly

Submit the job to the cluster(assuming that you're executing this in Spark's root folder):

    $ ./bin/spark-submit --master spark://cluster-master:7077 --class JavaWordCount path/to/target/scala-2.10/mongo-spark-assembly-1.0.jar
    $ mongo tyrone/beowulf --eval 'printjson(db.output.find().toArray())' | less



License
-------

The code itself is released to the public domain according to the [Creative Commons CC0][3].

The example files are based on [Beowulf][4] from Project Gutenberg and is under its corresponding license.

[3]: http://creativecommons.org/publicdomain/zero/1.0/
[4]: http://www.gutenberg.org/ebooks/981
