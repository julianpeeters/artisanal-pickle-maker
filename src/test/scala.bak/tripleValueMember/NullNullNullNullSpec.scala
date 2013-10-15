package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class NullNullNullNullSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_NullNullNullNull"), List(("k1", "Null"), ("k2", "Null"), ("k3", "Null"), ("k4", "Null")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_NullNullNullNull].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_NullNullNullNull(k1: Null, k2: Null, k3: Null, k4: Null)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
