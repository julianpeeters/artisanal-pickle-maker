package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class IntIntIntIntSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IntIntIntInt"), List(("c1", "Int"), ("c2", "Int"), ("c3", "Int"), ("c4", "Int")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_IntIntIntInt].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_IntIntIntInt(c1: Int, c2: Int, c3: Int, c4: Int)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
