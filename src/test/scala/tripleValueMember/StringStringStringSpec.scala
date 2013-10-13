package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class StringStringStringSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringStringString"), List(("h1", "String"), ("h2", "String"), ("h3", "String")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_StringStringString].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_StringStringString(h1: String, h2: String, h3: String)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
