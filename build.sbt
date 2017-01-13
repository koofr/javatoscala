name := "javatoscala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.mysema.scalagen" %% "scalagen" % "0.3.2"
)

resolvers += "Koofr Maven repo" at "http://koofr.github.com/repo/maven/"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
