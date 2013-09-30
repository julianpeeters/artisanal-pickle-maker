package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class IntIntIntSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IntIntInt"), List(("c1", "Int"), ("c2", "Int"), ("c3", "Int")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_IntIntInt].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_IntIntInt(c1: Int, c2: Int, c3: Int)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
