package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class UnitUnitUnitSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_UnitUnitUnit"), List(("j1", "Unit"), ("j2", "Unit"), ("j3", "Unit")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_UnitUnitUnit].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_UnitUnitUnit(j1: Unit, j2: Unit, j3: Unit)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
