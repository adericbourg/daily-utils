name := "daily-utils"

version := "0.0.1"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

libraryDependencies += "com.typesafe" % "config" % "1.3.1" % Provided

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test

