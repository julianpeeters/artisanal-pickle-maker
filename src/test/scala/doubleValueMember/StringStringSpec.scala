package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class StringStringSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringString"), List(("h1", "String"), ("h2", "String")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_StringString].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_StringString(h1: String, h2: String)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
