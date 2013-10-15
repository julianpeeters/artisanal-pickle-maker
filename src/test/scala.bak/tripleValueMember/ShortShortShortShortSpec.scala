package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ShortShortShortShortSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ShortShortShortShort"), List(("b1", "Short"), ("b2", "Short"), ("b3", "Short"), ("b4", "Short")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_ShortShortShortShort].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_ShortShortShortShort(b1: Short, b2: Short, b3: Short, b4: Short)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
