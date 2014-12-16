import sbt._
import Keys._

name := "artisanal-pickle-maker"

version := "0.10.1"

organization := "com.julianpeeters"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq( 
  "org.specs2" %% "specs2" % "2.4" % "test",
  "com.novus" %% "salat" % "1.9.9" % "test",
  "org.scala-lang" % "scala-compiler" % scalaVersion.value
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

homepage := Some(url("https://github.com/julianpeeters/artisanal-pickle-maker"))

pomExtra := (
      <scm>
        <url>git://github.com/julianpeeters/artisanal-pickle-maker.git</url>
        <connection>scm:git://github.com/julianpeeters/artisanal-pickle-maker.git</connection>
      </scm>
      <developers>
        <developer>
          <id>julianpeeters</id>
          <name>Julian Peeters</name>
          <url>http://github.com/julianpeeters</url>
        </developer>
      </developers>)
