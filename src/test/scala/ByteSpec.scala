package avocet 

import models._
import java.util.Arrays
import java.io.{File, PrintStream}
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled

import org.specs2._
import mutable._
import specification._

class ByteSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Byte"), List(("a", "Byte")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Byte].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_Byte(a: Byte)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
