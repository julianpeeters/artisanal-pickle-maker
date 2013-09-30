package avocet 

import models._
import java.util.Arrays
import scala.reflect.generic._

import org.specs2._
import mutable._
import specification._

class ObjectObjectSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ObjectObject"), List(("o1", "Object"), ("o2", "Object")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_ObjectObject].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

           
  "a ScalaSig for case class MyRecord_ObjectObject(o1: Object, o2: Object)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}
