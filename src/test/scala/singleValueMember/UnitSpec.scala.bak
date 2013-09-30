package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class UnitSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Unit"), List(("j", "Unit")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Unit].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_Unit(j: Unit)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
