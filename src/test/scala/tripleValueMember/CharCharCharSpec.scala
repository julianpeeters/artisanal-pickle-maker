package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class CharCharCharSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_CharCharChar"), List(("g1", "Char"), ("g2", "Char"), ("g3", "Char")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_CharCharChar].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_CharCharChar(g1: Char, g2: Char, g3: Char)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
