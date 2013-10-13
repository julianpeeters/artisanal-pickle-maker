package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class BooleanBooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_BooleanBoolean"), List(("i1", "Boolean"), ("i2", "Boolean")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_BooleanBoolean].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_BooleanBoolean(i2: Boolean, i2: Boolean)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
