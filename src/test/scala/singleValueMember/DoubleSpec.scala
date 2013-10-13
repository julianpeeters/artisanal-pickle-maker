package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class DoubleSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Double"), List(("f", "Double")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Double].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Double(f: Double)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
