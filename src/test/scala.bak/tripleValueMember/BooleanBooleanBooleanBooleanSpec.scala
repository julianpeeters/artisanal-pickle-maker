package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class BooleanBooleanBooleanBooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_BooleanBooleanBoolean"), List(("i1", "Boolean"), ("i2", "Boolean"), ("i3", "Boolean"), ("i4", "Boolean")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_BooleanBooleanBoolean].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_BooleanBooleanBoolean(i2: Boolean, i2: Boolean, i3: Boolean, i4: Boolean)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
