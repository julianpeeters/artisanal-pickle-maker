import com.banno.license.Plugin.LicenseKeys._
import com.banno.license.Licenses._

licenseSettings

license := apache2("Copyright 2013 Julian Peeters")

removeExistingHeaderBlock := true

name := "artisinal-pickle-maker"

version := "0.3-SNAPSHOT"

organization := "com.julianpeeters"

//scalaVersion := "2.9.1"
scalaVersion := "2.10.2"

resolvers += Resolver.file("Local Ivy Repository", file("/home/julianpeeters/.ivy2/local/"))(Resolver.ivyStylePatterns)

resolvers ++= Seq(
  "sonatype" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq( 
 // "org.specs2" %% "specs2" % "1.12" % "test",
  "org.specs2" %% "specs2" % "2.2" % "test",
//  "org.scala-lang" % "scala-compiler" % "2.9.1"
   "com.novus" %% "salat" % "1.9.3" % "test",
  "org.scala-lang" % "scala-compiler" % "2.10.2"
)

