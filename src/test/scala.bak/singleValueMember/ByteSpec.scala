package avocet 

import models._
import java.util.Arrays

import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ByteSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Byte"), List(("a", "Byte")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Byte].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Byte(a: Byte)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
