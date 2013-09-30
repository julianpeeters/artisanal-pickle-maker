name := "artisinal-pickle-maker"

version := "0.2-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "sonatype" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq( 
  "org.specs2" %% "specs2" % "1.12" % "test",
  "org.scala-lang" % "scala-compiler" % "2.9.1"
)

