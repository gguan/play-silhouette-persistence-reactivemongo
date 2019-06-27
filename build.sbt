import xerial.sbt.Sonatype._

import scalariform.formatter.preferences._

//*******************************
// Play settings
//*******************************

name := "play-silhouette-persistence-reactivemongo"

version := "6.0.0"

scalaVersion := "2.12.8"

crossScalaVersions := Seq("2.12.8", "2.13.0")

resolvers += Resolver.jcenterRepo

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "com.mohiva" %% "play-silhouette" % "6.0.0",
  "com.mohiva" %% "play-silhouette-persistence" % "6.0.0",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.17.1-play27",
  "net.codingwell" %% "scala-guice" % "4.2.5" % "test",
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "2.2.0" % "test",
  specs2 % Test
)

lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin)

//*******************************
// Compiler settings
//*******************************

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen" // Warn when numerics are widened.
)

//*******************************
// Test settings
//*******************************

parallelExecution in Test := false

fork in Test := true

// Needed to avoid https://github.com/travis-ci/travis-ci/issues/3775 in forked tests
// in Travis with `sudo: false`.
// See https://github.com/sbt/sbt/issues/653
// and https://github.com/travis-ci/travis-ci/issues/3775
javaOptions += "-Xmx1G"

//*******************************
// Maven settings
//*******************************

sonatypeSettings

organization := "com.mohiva"

description := "ReactiveMongo persistence module for Silhouette"

homepage := Some(url("http://silhouette.mohiva.com/"))

licenses := Seq("Apache License" -> url("https://github.com/mohiva/play-silhouette-persistence-reactivemongo/blob/master/LICENSE"))

val pom = <scm>
    <url>git@github.com:mohiva/play-silhouette-persistence-reactivemongo.git</url>
    <connection>scm:git:git@github.com:mohiva/play-silhouette-persistence-reactivemongo.git</connection>
  </scm>
    <developers>
      <developer>
        <id>akkie</id>
        <name>Christian Kaps</name>
        <url>http://mohiva.com</url>
      </developer>
    </developers>

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

sources in (Compile,doc) := Seq.empty

pomExtra := pom

//********************************************************
// Scalariform settings
//********************************************************

scalariformPreferences := scalariformPreferences.value
  .setPreference(FormatXml, false)
  .setPreference(DanglingCloseParenthesis, Preserve)
  .setPreference(AlignParameters, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, true)
  .setPreference(SpacesAroundMultiImports, true)
  .setPreference(IndentWithTabs, true)