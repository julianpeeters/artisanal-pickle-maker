name := "artisinal-pickle-maker"

version := "0.3-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "sonatype" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq( 
  "org.specs2" %% "specs2" % "2.2" % "test",
  "com.novus" %% "salat" % "1.9.4" % "test",
  "org.scala-lang" % "scala-compiler" % "2.10.2"
)

