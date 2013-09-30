package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class UnitUnitSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_UnitUnit"), List(("j1", "Unit"),("j2", "Unit")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_UnitUnit].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_UnitUnit(j1: Unit, j2: Unit)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
