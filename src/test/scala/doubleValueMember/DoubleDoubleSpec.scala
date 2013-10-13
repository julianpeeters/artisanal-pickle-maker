package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class DoubleDoubleSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_DoubleDouble"), List(("f1", "Double"), ("f2", "Double")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_DoubleDouble].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_DoubleDouble(f1: Double, f2: Double)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
