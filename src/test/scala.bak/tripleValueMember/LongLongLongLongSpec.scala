package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class LongLongLongLongSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_LongLongLongLong"), List(("d1", "Long"), ("d2", "Long"), ("d3", "Long"), ("d4", "Long")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_LongLongLongLong].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_LongLongLongLong(d1: Long, d2: Long, d3: Long, d4: Long)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
