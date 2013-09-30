package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class FloatFloatFloatSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_FloatFloatFloat"), List(("e1", "Float"), ("e2","Float"), ("e3","Float")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_FloatFloatFloat].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_FloatFloatFloat(e1: Float, e2: Float, e3: Float)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
