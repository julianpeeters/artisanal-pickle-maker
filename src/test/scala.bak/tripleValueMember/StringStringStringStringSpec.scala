package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class StringStringStringStringSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringStringStringString"), List(("h1", "String"), ("h2", "String"), ("h3", "String"), ("h4", "String")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_StringStringStringString].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_StringStringStringString(h1: String, h2: String, h3: String, h4: String)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
