package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ObjectSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Object"), List(("o", "Object")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Object].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

            
  "a ScalaSig for case class MyRecord_Object(o: Object)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
