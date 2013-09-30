package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class ShortShortSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ShortShort"), List(("b1", "Short"), ("b2", "Short")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_ShortShort].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_ShortShort(b1: Short, b2: Short)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
