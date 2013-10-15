package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class LongLongLongSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_LongLongLong"), List(("d1", "Long"), ("d2", "Long"), ("d3", "Long")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_LongLongLong].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_LongLongLong(d1: Long, d2: Long, d3: Long)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
