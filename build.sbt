name := "daily-utils"

lazy val typesafeConfig = (project in file("typesafe/config"))
  .settings(name := "daily-utils-typesafe-config")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.1" % Provided,
    "org.scalatest" %% "scalatest" % "3.0.1" % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test
  ))
