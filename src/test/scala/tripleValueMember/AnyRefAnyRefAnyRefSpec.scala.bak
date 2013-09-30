package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class AnyRefAnyRefAnyRefSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyRefAnyRefAnyRef"), List(("n1", "AnyRef"), ("n2", "AnyRef"), ("n3", "AnyRef")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyRefAnyRefAnyRef].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_AnyRefAnyRefAnyRef(n1: AnyRef, n2: AnyRef, n3: AnyRef)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
