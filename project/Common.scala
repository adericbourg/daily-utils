import sbt.Keys.{publishArtifact, _}
import sbt._

object Common {

  val Settings: Seq[Def.Setting[_]] = inThisBuild(Seq(
    organization := "net.dericbourg",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.1",
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1"),
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  ))

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
      <url>https://github.com/adericbourg/daily-utils</url>
        <licenses>
          <license>
            <name>GNU General Public Licence version 3</name>
            <url>https://www.gnu.org/licenses/</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
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
            <url>https://github.com/adericbourg/daily-utils</url>
          </developer>
        </developers>
    }
  )
}