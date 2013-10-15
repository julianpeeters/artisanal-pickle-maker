package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class AnyRefAnyRefAnyRefAnyRefSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyRefAnyRefAnyRef"), List(("n1", "AnyRef"), ("n2", "AnyRef"), ("n3", "AnyRef"), ("n4", "AnyRef")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_AnyRefAnyRefAnyRef].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
}

  "a ScalaSig for case class MyRecord_AnyRefAnyRefAnyRef(n1: AnyRef, n2: AnyRef, n3: AnyRef, n4: AnyRef)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
