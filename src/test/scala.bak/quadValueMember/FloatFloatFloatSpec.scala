package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class FloatFloatFloatSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_FloatFloatFloat"), List(("e1", "Float"), ("e2","Float"), ("e3","Float")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_FloatFloatFloat].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_FloatFloatFloat(e1: Float, e2: Float, e3: Float)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
