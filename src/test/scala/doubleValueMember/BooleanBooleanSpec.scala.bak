package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class BooleanBooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_BooleanBoolean"), List(("i1", "Boolean"), ("i2", "Boolean")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_BooleanBoolean].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_BooleanBoolean(i2: Boolean, i2: Boolean)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
