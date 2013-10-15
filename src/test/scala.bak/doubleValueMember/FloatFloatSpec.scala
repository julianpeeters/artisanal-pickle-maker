package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class FloatFloatSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_FloatFloat"), List(("e1", "Float"), ("e2","Float")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_FloatFloat].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_FloatFloat(e1: Float, e2: Float)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
