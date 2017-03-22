name := "daily-utils"

lazy val typesafeConfig = (project in file("typesafe/config"))
  .settings(name := "typesafe-config")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies += "com.typesafe" % "config" % "1.3.1" % Provided)
  .settings(Tests.Dependencies)

lazy val twitterTestFuture = (project in file("twitter/test-future"))
  .settings(name := "twitter-future")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies ++= Seq(
    { scalaVersion(Twitter.utilCoreDependency).value } % Provided,
    "org.scalactic" %% "scalactic" % "3.0.1" % Provided,
    "org.scalatest" %% "scalatest" % "3.0.1" % Provided
  ))
  .settings(Tests.Dependencies)
