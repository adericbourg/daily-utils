import sbt.Keys.{publishArtifact, _}
import sbt._

object Common {

  val Settings: Seq[Def.Setting[_]] = Seq(
    organization := "net.dericbourg.daily-utils",
    version := "0.1.6",
    scalaVersion := "2.12.1",
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1"),
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

  val Logging = Seq(
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
    )
  )

  val PublishMaven: Seq[Def.Setting[_]] = Seq(
    licenses := Seq("GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html")),
    homepage := Some(url("https://github.com/adericbourg/daily-utils")),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra := {
        <scm>
          <connection>scm:git:git@github.com:adericbourg/daily-utils.git</connection>
          <url>scm:git:git@github.com:adericbourg/daily-utils.git</url>
          <developerConnection>scm:git:git@github.com:adericbourg/daily-utils.git</developerConnection>
          <tag>HEAD</tag>
        </scm>
        <developers>
          <developer>
            <id>adericbourg</id>
            <name>Alban Dericbourg</name>
            <email>alban@dericbourg.net</email>
            <url>https://github.com/adericbourg</url>
          </developer>
        </developers>
    }
  )
}
