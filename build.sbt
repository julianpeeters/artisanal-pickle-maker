name := "artisinal-pickle-maker"

version := "0.1-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.10.2"
//sbt test
//scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq(
  "sonatype" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq( 
  "org.specs2" %% "specs2" % "2.1.1" % "test",
  "org.scala-lang" % "scala-compiler" % "2.10.2"
)

