package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ShortSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Short"), List(("b", "Short")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Short].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Short(b: Short)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
