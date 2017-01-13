name := "javatoscala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.mysema.scalagen" %% "scalagen" % "0.4.0"
)

resolvers += "Koofr Maven repo" at "http://koofr.github.com/repo/maven/"
resolvers += Resolver.bintrayRepo("nightscape", "maven")

lazy val root = (project in file(".")).enablePlugins(PlayScala)
