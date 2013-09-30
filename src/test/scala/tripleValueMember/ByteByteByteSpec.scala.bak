package avocet 

import models._
import java.util.Arrays

import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class ByteByteByteSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ByteByteByte"), List(("a1", "Byte"), ("a2", "Byte"), ("a3", "Byte")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_ByteByteByte].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_ByteByteByte(a1: Byte, a2: Byte, a3: Byte)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
