name := "daily-utils"

lazy val root = project.in(file("."))
  .settings(name := "daily-utils-all")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .aggregate(scalaLib, typesafeConfig, twitterUtils, twitterTestFuture)


lazy val scalaLib = (project in file("scala/lib"))
  .settings(name := "scala-lib")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(Tests.Dependencies)

lazy val typesafeConfig = (project in file("typesafe/config"))
  .settings(name := "typesafe-config")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies += "com.typesafe" % "config" % "1.3.1" % Provided)
  .settings(Tests.Dependencies)

lazy val twitterUtils = (project in file("twitter/utils"))
  .settings(name := "twitter-utils")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies += { scalaVersion(Twitter.utilCoreDependency).value } % Provided)
  .settings(Tests.Dependencies)

lazy val twitterTestFuture = (project in file("twitter/test-future"))
  .settings(name := "twitter-test-future")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies ++= Seq(
    { scalaVersion(Twitter.utilCoreDependency).value } % Provided,
    "org.scalactic" %% "scalactic" % "3.0.1" % Provided,
    "org.scalatest" %% "scalatest" % "3.0.1" % Provided
  ))
  .settings(Tests.Dependencies)
