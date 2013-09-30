package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class AnyAnySpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyAny"), List(("m1", "Any"), ("m2", "Any")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyAny].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_AnyAny(m1: Any, m2: Any)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes//:+(0.toByte)
    }
  }

}
