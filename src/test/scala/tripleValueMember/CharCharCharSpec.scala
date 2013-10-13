package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class CharCharCharSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_CharCharChar"), List(("g1", "Char"), ("g2", "Char"), ("g3", "Char")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_CharCharChar].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_CharCharChar(g1: Char, g2: Char, g3: Char)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
