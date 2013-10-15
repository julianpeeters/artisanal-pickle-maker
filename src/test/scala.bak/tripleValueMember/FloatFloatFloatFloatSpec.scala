package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class FloatFloatFloatFloatSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_FloatFloatFloatFloat"), List(("e1", "Float"), ("e2","Float"), ("e3","Float"), ("e4","Float")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_FloatFloatFloatFloat].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_FloatFloatFloatFloat(e1: Float, e2: Float, e3: Float, e4: Float)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
