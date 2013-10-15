package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class CharCharCharCharSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_CharCharCharChar"), List(("g1", "Char"), ("g2", "Char"), ("g3", "Char"), ("g4", "Char")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_CharCharCharChar].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_CharCharCharChar(g1: Char, g2: Char, g3: Char, g4: Char)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
