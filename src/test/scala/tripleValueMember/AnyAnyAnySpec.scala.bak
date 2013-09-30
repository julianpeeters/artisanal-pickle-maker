package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class AnyAnyAnySpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyAnyAny"), List(("m1", "Any"), ("m2", "Any"), ("m3", "Any")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyAnyAny].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_AnyAnyAny(m1: Any, m2: Any, m3: Any)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes//:+(0.toByte)
    }
  }

}
