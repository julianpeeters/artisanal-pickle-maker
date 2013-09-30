package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class CharCharSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_CharChar"), List(("g1", "Char"), ("g2", "Char")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_CharChar].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_CharChar(g1: Char, g2: Char)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
