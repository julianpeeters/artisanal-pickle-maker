package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class ObjectObjectObjectObjectSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ObjectObjectObjectObject"), List(("o1", "Object"), ("o2", "Object"), ("o3", "Object"), ("o3", "Object")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_ObjectObjectObjectObject].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }
       
  "a ScalaSig for case class MyRecord_ObjectObjectObjectObject(o1: Object, o2: Object, o3: Object, o4: Object)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
