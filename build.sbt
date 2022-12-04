ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val testDependencies =
  new {
    val scalaCheckV = "1.15.4"
    val scalaTestPlusV = "3.2.14.0"
    val scalaTestV = "3.2.14"

    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestV % "test"
  }

lazy val dependencies =
  new {
    val scalaUriV = "4.0.3"
    val fastParseV = "2.2.2"
    val catsParseV = "0.3.7"

    val scalaUri = "io.lemonlabs" %% "scala-uri" % scalaUriV
    val catsParse = "org.typelevel" %% "cats-parse" % catsParseV
  }

lazy val commonTestDependencies = Seq(
  testDependencies.scalaTest
)

lazy val root = (project in file("."))
  .settings(
    name := "RobotsTxt",
    libraryDependencies ++= commonTestDependencies ++ Seq(
      dependencies.scalaUri,
      dependencies.catsParse
    ),
    idePackagePrefix := Some("com.onliner10.robotstxt")
  )
