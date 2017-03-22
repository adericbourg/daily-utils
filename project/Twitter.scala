import sbt._

object Twitter {

  def utilCoreDependency(scalaVersion: String): ModuleID = scalaVersion match {
    case _ if scalaVersion.startsWith("2.10.") => "com.twitter" %% "util-core" % "6.34.0"
    case _ => "com.twitter" %% "util-core" % "6.42.0"
  }
}
