package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class IntIntIntSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IntIntInt"), List(("c1", "Int"), ("c2", "Int"), ("c3", "Int")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_IntIntInt].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_IntIntInt(c1: Int, c2: Int, c3: Int)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
