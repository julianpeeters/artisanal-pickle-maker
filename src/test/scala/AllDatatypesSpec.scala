package avocet 

import models._
import java.util.Arrays

import scala.reflect.generic._


import org.specs2._
import mutable._
import specification._
import execute.Success

class AllDatatypesSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AllDatatypes"), List(("a", "Byte"), ("b", "Short"), ("c", "Int"), ("d", "Long"), ("e", "Float"), ("f", "Double"), ("g", "Char"), ("h", "String"), ("i", "Boolean"), ("j", "Unit"), ("k", "Null"), ("l", "Nothing"), ("m", "Any"), ("n", "Byte"), ("o", "Object")))


  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AllDatatypes].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes("UTF-8")
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for a case class with all supported datatypes (MyRecord_AllDatatypes) " should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes:+(0.toByte)
    }
  }
 
}

