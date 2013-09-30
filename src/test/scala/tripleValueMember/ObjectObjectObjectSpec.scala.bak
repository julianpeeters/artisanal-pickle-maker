package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class ObjectObjectObjectSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ObjectObjectObject"), List(("o1", "Object"), ("o2", "Object"), ("o3", "Object")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_ObjectObjectObject].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

           
  "a ScalaSig for case class MyRecord_ObjectObjectObject(o1: Object, o2: Object, o3: Object)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
