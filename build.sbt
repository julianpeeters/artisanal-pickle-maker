import sbt._
import Keys._

name := "artisinal-pickle-maker"

version := "0.6-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq( 
  "org.specs2" %% "specs2" % "2.2" % "test",
  "com.novus" %% "salat" % "1.9.4" % "test",
  "org.scala-lang" % "scala-compiler" % "2.10.2"
)

publishMavenStyle := true

publishArtifact in Test := false

publishTo <<= version { (v: String) =>
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    }

pomIncludeRepository := { _ => false }

licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://github.com/julianpeeters/artisinal-pickle-maker"))

pomExtra := (
      <scm>
        <url>git://github.com/julianpeeters/artisinal-pickle-maker.git</url>
        <connection>scm:git://github.com/julianpeeters/artisinal-pickle-maker.git</connection>
      </scm>
      <developers>
        <developer>
          <id>julianpeeters</id>
          <name>Julian Peeters</name>
          <url>http://github.com/julianpeeters</url>
        </developer>
      </developers>)
