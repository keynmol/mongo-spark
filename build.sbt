import AssemblyKeys._ // put this at the top of the file,leave the next line blank

assemblySettings


name := "mongo-spark"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.2.0" % "provided"

// Select which Hadoop version to use
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.4.0" % "provided"

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.11.4" 

retrieveManaged := true

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

resolvers += Resolver.sonatypeRepo("public")
