package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class IntIntSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IntInt"), List(("c1", "Int"), ("c2", "Int")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_IntInt].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_IntInt(c1: Int, c2: Int)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
