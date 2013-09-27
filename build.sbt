name := "javatoscala"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.mysema.scalagen" %% "scalagen" % "0.3.2"
)

resolvers += "Koofr Maven repo" at "http://koofr.github.com/repo/maven/"

play.Project.playScalaSettings
