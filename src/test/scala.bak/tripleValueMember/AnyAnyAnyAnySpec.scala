package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class AnyAnyAnyAnySpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyAnyAnyAny"), List(("m1", "Any"), ("m2", "Any"), ("m3", "Any"), ("m4", "Any")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_AnyAnyAnyAny].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_AnyAnyAny(m1: Any, m2: Any, m3: Any, m4: Any)" should {
    "have the correct string" in {
      mySig.bytes === correctSig//:+(0.toByte)
    }
  }

}
