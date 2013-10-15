package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class NullNullSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_NullNull"), List(("k1", "Null"), ("k2", "Null")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_NullNull].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_NullNull(k1: Null, k2: Null)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
