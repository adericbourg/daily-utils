name := "daily-utils"

lazy val buildSettings = Seq(
  organization := "net.dericbourg",
  version := "2.4-SNAPSHOT",
  scalaVersion := "2.12.1",
  crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")
)

libraryDependencies += "com.typesafe" % "config" % "1.3.1" % Provided

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ =>
  false
}

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
