package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class UnitUnitSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_UnitUnit"), List(("j1", "Unit"),("j2", "Unit")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_UnitUnit].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_UnitUnit(j1: Unit, j2: Unit)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
