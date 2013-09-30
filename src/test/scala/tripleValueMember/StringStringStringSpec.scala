package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class StringStringStringSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringStringString"), List(("h1", "String"), ("h2", "String"), ("h3", "String")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_StringStringString].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_StringStringString(h1: String, h2: String, h3: String)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
