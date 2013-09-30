package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class FloatSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Float"), List(("e", "Float")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Float].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_Float(e: Float)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
