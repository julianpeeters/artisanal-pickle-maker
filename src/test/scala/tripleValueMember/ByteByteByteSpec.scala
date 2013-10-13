package avocet 

import models._
import java.util.Arrays

import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ByteByteByteSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ByteByteByte"), List(("a1", "Byte"), ("a2", "Byte"), ("a3", "Byte")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_ByteByteByte].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_ByteByteByte(a1: Byte, a2: Byte, a3: Byte)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
