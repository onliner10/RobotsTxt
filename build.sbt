ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val testDependencies =
  new {
    val scalaCheckV = "1.15.4"
    val scalaTestPlusV = "3.2.14.0"
    val scalaTestV = "3.2.14"

    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestV % "test"
    val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckV % "test"
    val scalaTestPlus = "org.scalatestplus" %% "scalacheck-1-17" % scalaTestPlusV % "test"
  }

lazy val dependencies =
  new {
    val scalaUriV = "4.0.3"

    val scalaUri = "io.lemonlabs" %% "scala-uri" % scalaUriV
  }

lazy val commonTestDependencies = Seq(
  testDependencies.scalaCheck,
  testDependencies.scalaTestPlus,
  testDependencies.scalaTest
)

lazy val root = (project in file("."))
  .settings(
    name := "RobotsTxt",
    libraryDependencies ++= commonTestDependencies ++ Seq(
      dependencies.scalaUri
    ),
    idePackagePrefix := Some("com.onliner10.robotstxt")
  )
