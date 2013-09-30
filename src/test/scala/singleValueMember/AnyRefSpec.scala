package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class AnyRefSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyRef"), List(("n", "AnyRef")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyRef].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_AnyRef(n: AnyRef)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
