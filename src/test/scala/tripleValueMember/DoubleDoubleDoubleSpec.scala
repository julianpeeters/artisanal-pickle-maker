package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class DoubleDoubleDoubleSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_DoubleDoubleDouble"), List(("f1", "Double"), ("f2", "Double"), ("f3", "Double")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_DoubleDoubleDouble].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_DoubleDoubleDouble(f1: Double, f2: Double, f3: Double)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
