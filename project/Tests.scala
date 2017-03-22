import sbt.Keys.libraryDependencies
import sbt._

object Tests {
  val Dependencies = Seq(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % Test,
      "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test
    )
  )
}