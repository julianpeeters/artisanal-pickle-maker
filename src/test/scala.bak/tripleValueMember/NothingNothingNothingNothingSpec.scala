package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class NothingNothingNothingNothingSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_NothingNothingNothingNothing"), List(("l1", "Nothing"), ("l2", "Nothing"), ("l3", "Nothing"), ("l4", "Nothing")))

  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_NothingNothingNothingNothing].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_NothingNothingNothingNothing(l1: Nothing, l2: Nothing, l3: Nothing, l4: Nothing)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
